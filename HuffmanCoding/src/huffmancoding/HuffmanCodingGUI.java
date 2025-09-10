//Group 12
//Muhammad Asim Ilyas (FA22-BSE-111)          (1st Member)    Group Leader
//Muhammad Faizyab    (FA22-BSE-017)          (3rd Member)  
//Fahim ullah         (SP22-BSE-024)          (2nd Member)

package huffmancoding;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HuffmanCodingGUI extends JFrame {
    
    private JTextArea inputTextArea;
    private JTextArea originalBinaryArea;
    private JTextArea compressedBinaryArea;
    private JLabel originalSizeLabel;
    private JLabel compressedSizeLabel;
    private JLabel sizeDifferenceLabel;
    private HuffmanCoding.HuffmanResult result;

    public HuffmanCodingGUI() {
        // Frame setup
        setTitle("Huffman Coding Compression");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and add panels
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(70, 130, 180));
        JButton uploadButton = new JButton("Upload File");
        JButton compressButton = new JButton("Compress Text");
        JButton clearButton = new JButton("Clear");
        
        uploadButton.setFont(new Font("Arial", Font.BOLD, 16));
        uploadButton.setForeground(Color.BLACK);
        uploadButton.setBackground(new Color(100, 149, 237));
        compressButton.setFont(new Font("Arial", Font.BOLD, 16));
        compressButton.setForeground(Color.BLACK);
        compressButton.setBackground(new Color(100, 149, 237));
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setForeground(Color.BLACK);
        clearButton.setBackground(new Color(100, 149, 237));

        topPanel.add(uploadButton);
        topPanel.add(compressButton);
        topPanel.add(clearButton);
        add(topPanel, BorderLayout.NORTH);

        // Center panel with text areas and labels
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Input text panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputTextArea = createTextArea("Enter Text to Compress:");
        inputPanel.add(createScrollPane(inputTextArea), BorderLayout.CENTER);
        
        // Binary data panel
        JPanel originalPanel = new JPanel(new BorderLayout());
        originalBinaryArea = createTextArea("Original Binary Data:");
        originalSizeLabel = createLabel("Original Size: ");
        originalPanel.add(createScrollPane(originalBinaryArea), BorderLayout.CENTER);
        originalPanel.add(originalSizeLabel, BorderLayout.SOUTH);

        JPanel compressedPanel = new JPanel(new BorderLayout());
        compressedBinaryArea = createTextArea("Compressed Binary Data:");
        compressedSizeLabel = createLabel("Compressed Size: ");
        sizeDifferenceLabel = createLabel("Size Difference: ");
        compressedPanel.add(createScrollPane(compressedBinaryArea), BorderLayout.CENTER);
        compressedPanel.add(compressedSizeLabel, BorderLayout.SOUTH);
        compressedPanel.add(sizeDifferenceLabel, BorderLayout.NORTH);

        tabbedPane.addTab("Input Text", inputPanel);
        tabbedPane.addTab("Original Data", originalPanel);
        tabbedPane.addTab("Compressed Data", compressedPanel);

        add(tabbedPane, BorderLayout.CENTER);

        // Action listeners for buttons
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
                int result = fileChooser.showOpenDialog(HuffmanCodingGUI.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    processFile(selectedFile);
                }
            }
        });

        compressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputTextArea.getText();
                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(HuffmanCodingGUI.this, "Please enter text to compress.", "Input Required", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                result = HuffmanCoding.compress(text);
                displayResults();
                try {
                    HuffmanCoding.writeBinaryFile("OriginalFile.bin", result.originalBinary);
                    HuffmanCoding.writeBinaryFile("output.bin", result.compressedBinary);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(HuffmanCodingGUI.this, "Error writing binary file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputTextArea.setText("");
                originalBinaryArea.setText("");
                compressedBinaryArea.setText("");
                originalSizeLabel.setText("Original Size: ");
                compressedSizeLabel.setText("Compressed Size: ");
                sizeDifferenceLabel.setText("Size Difference: ");
            }
        });
    }

    private JTextArea createTextArea(String title) {
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        textArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(100, 149, 237)), title));
        textArea.setBackground(new Color(240, 255, 255)); // Lighter blue background
        return textArea;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(new Color(25, 25, 112));
        return label;
    }

    private JScrollPane createScrollPane(JTextArea textArea) {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }

    private void processFile(File file) {
        try {
            String text = HuffmanCoding.readFile(file.getAbsolutePath());
            inputTextArea.setText(text);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayResults() {
        originalBinaryArea.setText(formatBinaryData(result.originalBinary));
        originalSizeLabel.setText("Original Size: " + result.originalSize + " bits");
        compressedBinaryArea.setText(formatBinaryData(result.compressedBinary));
        compressedSizeLabel.setText("Compressed Size: " + result.compressedSize + " bits");
        sizeDifferenceLabel.setText("Size Difference: " + (result.originalSize - result.compressedSize) + " bits");
    }

    private String formatBinaryData(String binaryData) {
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < binaryData.length(); i += 8) {
            if (i > 0) {
                formatted.append(" ");
            }
            formatted.append(binaryData, i, Math.min(i + 8, binaryData.length()));
        }
        return formatted.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HuffmanCodingGUI gui = new HuffmanCodingGUI();
            gui.setVisible(true);
        });
    }
}
