package dev.hust.leaf.healthcare.test;

import com.robotium.solo.Solo;

import dev.hust.leaf.healthcare.activity.MainActivity;
import android.test.ActivityInstrumentationTestCase2;

public class BUserInfoTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	private Solo solo;

	public BUserInfoTest() {
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

	public void testUserInfo() {
		assertTrue(solo.searchText("个人信息"));
		assertTrue(solo.searchText("设备信息"));
		assertTrue(solo.searchText("监护人"));
		assertTrue(solo.searchText("test1"));
		//solo.pressMenuItem(1);
		//assertTrue(solo.waitForText("test1"));
	}

}
