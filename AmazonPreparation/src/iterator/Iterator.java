/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

/**
 *
 * @author rajeshkumar.yadav
 */
public interface Iterator<E> {
    public boolean hasNext();
    public <E> E next();
}
