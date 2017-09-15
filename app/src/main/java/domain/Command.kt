package domain

/**
 * File Name:
 * Author:      ruan
 * Write Dates: 2017/9/14
 * Description:
 */
public interface Command<T> {
    fun execute():T
}