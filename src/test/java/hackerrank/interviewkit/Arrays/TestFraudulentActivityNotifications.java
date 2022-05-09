package hackerrank.interviewkit.Arrays;

import hackerrank.interviewkit.sorting.FraudulentActivityNotifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFraudulentActivityNotifications {

    @Test
    public void test_1(){
        int trailingDay = 3;
        int[] arr = {10, 20, 30, 40, 50};
        FraudulentActivityNotifications notifications = new FraudulentActivityNotifications();
        int count = notifications.countNotifications(arr, trailingDay);

        Assertions.assertEquals(1, count);
    }
}
