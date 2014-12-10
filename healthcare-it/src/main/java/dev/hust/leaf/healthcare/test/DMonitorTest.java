package dev.hust.leaf.healthcare.test;

import com.robotium.solo.Solo;

import dev.hust.leaf.healthcare.activity.MainActivity;
import android.test.ActivityInstrumentationTestCase2;

public class DMonitorTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	private Solo solo;

	public DMonitorTest() {
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

	private void enterMonitor() {
		solo.clickOnText("监护人");
		assertTrue(solo.waitForText("真实姓名"));
	}

	public void testAMonitor() {
		enterMonitor();
		//solo.pressMenuItem(1);
		//sassertTrue(solo.waitForText("真实姓名"));
	}

	public void testBMonitorInfo() {
		enterMonitor();
		solo.clickOnText("详细");
		//assertTrue(solo.waitForDialogToOpen());
		solo.goBack();
	}

	public void testCMonitorDail() {
		enterMonitor();
		solo.clickOnText("呼叫");
		assertTrue(solo.waitForDialogToOpen());
		solo.clickOnText("否");
	}

	public void testDMonitorEmail() {
		enterMonitor();
		//solo.clickLongOnText("邮件");
		solo.goBack();
	}

}
