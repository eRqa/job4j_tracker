package ru.job4j.examples.oop;

import junit.framework.TestCase;
import org.junit.Assert;

import static org.hamcrest.Matchers.is;

public class BatteryTest extends TestCase {

    public void testExchange() {

        Battery batteryOne = new Battery(10);
        Battery batteryTwo = new Battery(10);

        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 20;

        batteryOne.exchange(batteryTwo);

        int[] act = new int[2];
        act[0] = batteryOne.getLoad();
        act[1] = batteryTwo.getLoad();

        Assert.assertThat(act, is(expected));

    }

    public void testExchangeWhen20And40() {

        Battery batteryOne = new Battery(20);
        Battery batteryTwo = new Battery(40);

        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 60;

        batteryOne.exchange(batteryTwo);

        int[] act = new int[2];
        act[0] = batteryOne.getLoad();
        act[1] = batteryTwo.getLoad();

        Assert.assertThat(act, is(expected));

    }
}