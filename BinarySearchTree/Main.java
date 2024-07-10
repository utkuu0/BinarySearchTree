/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BinarySearchTree;

/**
 *
 * @author Emre
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        BST binarySearchTree = new BST();
        binarySearchTree.add(50);
        binarySearchTree.add(30);
        binarySearchTree.add(70);
        binarySearchTree.add(20);
        binarySearchTree.add(40);
        binarySearchTree.add(60);
        binarySearchTree.add(80);
        
        
        
        
        System.out.println("Aranan Değer (30): " + binarySearchTree.find(30)); // true
        System.out.println("Aranan Değer (45): " + binarySearchTree.find(45)); // false

        // Özyinelemeli olarak veriyi ara
        System.out.println("Aranan Değer (40): " + binarySearchTree.rfind(40)); // true
        System.out.println("Aranan Değer (55): " + binarySearchTree.rfind(55)); // false

        // Ağacı dolaş
        System.out.println("Preorder Dolaşma: " + binarySearchTree.walkInTree(BST.TreeTrevarsal.preOrder));
        System.out.println("Inorder Dolaşma: " + binarySearchTree.walkInTree(BST.TreeTrevarsal.inOrder));
        System.out.println("Postorder Dolaşma: " + binarySearchTree.walkInTree(BST.TreeTrevarsal.postOrder));
        System.out.println("Özel Sıralama: ");
        //binarySearchTree.walkInTree(BST.TreeTrevarsal.special);

        // Ağaca eleman ekle
        binarySearchTree.add(55);

        // Ağacı tekrar dolaş
        System.out.println("Inorder Dolaşma (Yeniden): " + binarySearchTree.walkInTree(BST.TreeTrevarsal.inOrder));

        // Elemanı sil
        binarySearchTree.delete(40);


        // Ağacı tekrar dolaş
        System.out.println("Inorder Dolaşma (Eleman Silindikten Sonra): " + binarySearchTree.walkInTree(BST.TreeTrevarsal.inOrder));
        
        
    }
    
}
