/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import tree.BinaryTree;

/**
 *
 * @author rajeshkumar.yadav
 */
public class BinaryTreeListener implements Listener{

    public BinaryTreeListener() {
        
    }
    
    public BinaryTreeListener(BinaryTree bt) {
        
    }

    @Override
    public boolean hasChanged() {
        return false;
    }
    
}
