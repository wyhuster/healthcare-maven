package dev.hust.leaf.healthcare.test;

import com.robotium.solo.Solo;

import dev.hust.leaf.healthcare.activity.MainActivity;
import android.test.ActivityInstrumentationTestCase2;

public class CDeviceInfoTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	private Solo solo;

	public CDeviceInfoTest() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp() throws Exception {
		// setUp() is run before a test case is started.
		// This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	public void tearDown() throws Exception {
		// tearDown() is run after a test case has finished.
		// finishOpenedActivities() will finish all the activities that have
		// been opened during the test execution.
		solo.finishOpenedActivities();
	}

	private void enterDeviceInfo() {
		solo.clickOnText("设备信息");
		assertTrue(solo.waitForText("设备编号"));
	}

	public void testADeviceInfo() {
		enterDeviceInfo();

		// solo.pressMenuItem(1);
		// assertTrue(solo.waitForText("设备编号"));
	}

	public void testBDeviceState() {
		enterDeviceInfo();

		assertTrue(solo.waitForText("设备状态"));
		solo.clickOnText("设备状态");
		assertTrue(solo.waitForDialogToOpen());
		solo.goBack();
	}

	public void testCDeviceData() {
		enterDeviceInfo();

		assertTrue(solo.waitForText("心电数据"));
		solo.clickOnText("心电数据");
		assertTrue(solo.waitForActivity("DataQueryActivity"));
		assertTrue(solo.waitForText("即时数据"));
		solo.clickOnButton("查询");
		assertTrue(solo.waitForText("没有数据"));

		//solo.pressMenuItem(0);
		//assertTrue(solo.waitForText("即时数据"));

		solo.clickOnActionBarHomeButton();
		if (!(solo.getCurrentActivity() instanceof MainActivity)) {
			assertTrue(false);
		}
	}

	public void testDDeviceException() {
		enterDeviceInfo();

		assertTrue(solo.waitForText("设备异常"));
		solo.clickOnText("设备异常");
		assertTrue(solo.waitForActivity("ExceptionActivity"));
		assertTrue(solo.waitForText("异常类型"));

		solo.pressSpinnerItem(0, 1);
		assertTrue(solo.waitForText("电池电量低"));

		//solo.pressMenuItem(0);
		//assertTrue(solo.waitForText("设备异常"));

		solo.clickOnActionBarHomeButton();
		if (!(solo.getCurrentActivity() instanceof MainActivity)) {
			assertTrue(false);
		}
	}

}
