package huffmancoding;
//Group 12
//Muhammad Asim Ilyas (FA22-BSE-111)          (1st Member)    Group Leader
//Muhammad Faizyab    (FA22-BSE-017)          (3rd Member)  
//Fahim ullah         (SP22-BSE-024)          (2nd Member)
import java.io.*;
import java.util.PriorityQueue;

public class HuffmanCoding
{

    public static String readFile(String filePath) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null)
        {
            stringBuilder.append(line);
        }
        reader.close();
        return stringBuilder.toString();
    }

    public static void writeBinaryFile(String filePath, String data) throws IOException
    {
        try (FileOutputStream fos = new FileOutputStream(filePath))
        {
            for (int i = 0; i < data.length(); i += 8)
            {
                int byteValue = Integer.parseInt(data.substring(i, Math.min(i + 8, data.length())), 2);
                fos.write(byteValue);
            }
        }
    }

    public static HuffmanResult compress(String text)
    {
        int[] frequencies = new int[256];

        // Count frequencies
        for (char c : text.toCharArray())
        {
            frequencies[c]++;
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        // Create leaf nodes and add to priority queue
        for (char i = 0; i < frequencies.length; i++)
        {
            if (frequencies[i] > 0)
            {
                priorityQueue.add(new Node(i, frequencies[i]));
            }
        }
        StringBuilder compressedData ;
        //if data has just one  character or same unique character
        if (priorityQueue.size() == 1)
        {
            Node singleNode = priorityQueue.poll();
            singleNode.buildCode("0");

            compressedData = new StringBuilder();
            for (char c : text.toCharArray())
            {
                compressedData.append("0");
            }
        } else
        {
            // Build Huffman Tree
            while (priorityQueue.size() > 1)
            {
                Node right = priorityQueue.poll();
                Node left = priorityQueue.poll();
                Node parent = new Node('\0', left.frequency + right.frequency, left, right);
                priorityQueue.add(parent);
            }

            Node root = priorityQueue.poll();
            if (root != null)
            {
                root.buildCode("");
            }

            compressedData = new StringBuilder();
            for (char c : text.toCharArray())
            {
                compressedData.append(root.getCode(c));
            }
        }
        byte[] byteArray = text.getBytes();
        StringBuilder originalBinaryData = new StringBuilder();
        for (byte b : byteArray)
        {
            String binaryString = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            originalBinaryData.append(binaryString);
        }

        return new HuffmanResult(text, originalBinaryData.toString(), text.length() * 8,
                compressedData.toString(), compressedData.length());
    }

    public static class HuffmanResult
    {

        public String originalText;
        public String originalBinary;
        public int originalSize;
        public String compressedBinary;
        public int compressedSize;

        public HuffmanResult(String originalText, String originalBinary, int originalSize, String compressedBinary, int compressedSize)
        {
            this.originalText = originalText;
            this.originalBinary = originalBinary;
            this.originalSize = originalSize;
            this.compressedBinary = compressedBinary;
            this.compressedSize = compressedSize;
        }
    }
}
