package hackerrank.interviewkit.Arrays;

import hackerrank.interviewkit.sorting.FraudulentActivityNotifications;
import org.junit.Assert;
import org.junit.Test;

public class TestFraudulentActivityNotifications {

    @Test
    public void test_1(){
        int trailingDay = 3;
        int[] arr = {10, 20, 30, 40, 50};
        FraudulentActivityNotifications notifications = new FraudulentActivityNotifications();
        int count = notifications.countNotifications(arr, trailingDay);

        Assert.assertEquals(1, count);
    }
}
