package org.thoughtworks.sg.command;

import org.junit.Assert;
import org.junit.Test;

public class CommandTypeTest {
    @Test
    public void shouldReturnQForTheExitType() {
        Assert.assertEquals("Q", CommandType.QUIT.getValue());
    }

    @Test
    public void shouldReturnBForTheBucketType() {
        Assert.assertEquals("B", CommandType.BUCKET.getValue());
    }

    @Test
    public void shouldReturnLForTheLineType() {
        Assert.assertEquals("L", CommandType.LINE.getValue());
    }

    @Test
    public void shouldReturnRForTheRectangleType() {
        Assert.assertEquals("R", CommandType.RECTANGLE.getValue());
    }

}
