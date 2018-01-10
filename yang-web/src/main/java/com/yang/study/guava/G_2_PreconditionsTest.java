package com.yang.study.guava;

import com.google.common.base.Preconditions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/8 上午1:07
 * @Description guava-2.PreConditions
 *      Preconditions主要用来断言参数是否正确，主要有以下六个方法
 *      1.checkArgument(boolean)	检查boolean是否为true，用来检查传递给方法的参数。
 *      2.checkNotNull(T)	    检查value是否为null，该方法直接返回value，因此可以内嵌使用checkNotNull。
 *      3.checkState(boolean)	用来检查对象的某些状态。
 *      4.checkElementIndex(int index, int size)	检查index作为索引值对某个列表、字符串或数组是否有效。
 *      5.checkPositionIndex(int index, int size)	检查index作为位置值对某个列表、字符串或数组是否有效。
 *      6.checkPositionIndexes(int start, int end, int size)	检查[start, end]表示的位置范围对某个列表、字符串或数组是否有效*
 */
public class G_2_PreconditionsTest {

    /**
     * 如果用参数模板，则通配符必须用%s
     * 1 .checkArgument(boolean) ：
     * 功能描述：检查boolean是否为真。 用作方法中检查参数
     * 失败时抛出的异常类型: IllegalArgumentException
     */
    @Test
    public void testCheckArgument() {
        int a = 5;
        System.out.println("--1--");
        Preconditions.checkArgument(a < 6);
        System.out.println("--2--");
        Preconditions.checkArgument(a > 6, "非法参数异常：{%s}", "入参格式不对");

    }

    /**
     * 2.checkNotNull(T)：
     * 功能描述：检查value不为null， 直接返回value；
     * 失败时抛出的异常类型：NullPointerException
     */
    @Test
    public void testChectNotNull() {
        List list = new ArrayList();
        List list2 = null;
        System.out.println("--step 3--");
        Preconditions.checkNotNull(list, "list is not null");
        System.out.println("--step 4--");
        Preconditions.checkNotNull(list2, "list2 is not null");
    }

    /**
     * 3.checkState(boolean)：
     * 功能描述：检查对象的一些状态，不依赖方法参数。 例如， Iterator可以用来next是否在remove之前被调用。
     * 失败时抛出的异常类型：IllegalStateException
     */
    @Test
    public void testChectState() {
        List list = new ArrayList();
        for (int index = 0; index < 10; index++) {
            try {
                Preconditions.checkState(list.size() < 9, " list size 不能大于" + index);
                list.add(index);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 4.checkElementIndex(int index, int size)：
     * 功能描述：检查index是否为在一个长度为size的list， string或array合法的范围。 index的范围区间是[0, size)(包含0不包含size)。无需直接传入list， string或array， 只需传入大小。返回index。
     * 失败时抛出的异常类型：IndexOutOfBoundsException
     */
    @Test
    public void testcheckElementIndex() {

    }


    /**
     * 5.checkPositionIndex(int index, int size)：
     * 功能描述：检查位置index是否为在一个长度为size的list， string或array合法的范围。 index的范围区间是[0， size)(包含0不包含size)。无需直接传入list， string或array， 只需传入大小。返回index。
     * 失败时抛出的异常类型：IndexOutOfBoundsException
     */
    @Test
    public void testcheckPositionIndex() {

    }

    /**
     * 6.checkPositionIndexes(int start, int end, int size)：
     * 功能描述：检查[start, end)是一个长度为size的list， string或array合法的范围子集。伴随着错误信息。
     * 失败时抛出的异常类型：IndexOutOfBoundsException
     */
    @Test
    public void testcheckPositionIndexes() {


    }
}
