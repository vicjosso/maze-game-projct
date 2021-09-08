/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import java.io.IOException;

/**
 *
 * @author vjosso
 */
public class InvalidLabyFileException extends IOException {

    /**
     * Creates a new instance of <code>InvalidLabyFileException</code> without
     * detail message.
     */
    public InvalidLabyFileException() {
    }

    /**
     * Constructs an instance of <code>InvalidLabyFileException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidLabyFileException(String msg) {
        super(msg);
    }
}
