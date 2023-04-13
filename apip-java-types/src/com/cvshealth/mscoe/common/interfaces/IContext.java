/**
 * 
 */
package com.cvshealth.mscoe.common.interfaces;

/**
 * @author pankaj.gupta
 *
 */
public interface IContext {
    <T> void set(String key, T value);
    <T> T get(String key);
}
