/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Group 12
//Muhammad Asim Ilyas (FA22-BSE-111)          (1st Member)    Group Leader
//Muhammad Faizyab    (FA22-BSE-017)          (3rd Member)  
//Fahim ullah         (SP22-BSE-024)          (2nd Member)
package huffmancoding;

/**
 *
 * @author WALEED TRADERS
 */
public class Node implements Comparable<Node> {
    char character;
    int frequency;
    Node left;
    Node right;
    String binCode = "";

    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public Node(char character, int frequency, Node left, Node right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public void buildCode(String code) {
        this.binCode = code;
        if (this.left != null) {
            this.left.buildCode(code + "0");
        }
        if (this.right != null) {
            this.right.buildCode(code + "1");
        }
    }

    public String getCode(char c) {
        if (this.character == c) {
            return this.binCode;
        }
        if (this.left != null) {
            String leftCode = this.left.getCode(c);
            if (leftCode != null) {
                return leftCode;
            }
        }
        if (this.right != null) {
            return this.right.getCode(c);
        }
        return null;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}

