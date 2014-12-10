package dev.hust.leaf.healthcare.test;

import com.robotium.solo.Solo;

import dev.hust.leaf.healthcare.activity.LoginActivity;
import dev.hust.leaf.healthcare.activity.MainActivity;
import android.test.ActivityInstrumentationTestCase2;

public class ALoginTest extends ActivityInstrumentationTestCase2<LoginActivity> {

	private Solo solo;

	public ALoginTest() {
		super(LoginActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp() throws Exception {
		// setUp() is run before a test case is started.
		// This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
		solo.unlockScreen();
	}

	@Override
	public void tearDown() throws Exception {
		// tearDown() is run after a test case has finished.
		// finishOpenedActivities() will finish all the activities that have
		// been opened during the test execution.
		solo.finishOpenedActivities();
	}

	public void testAEmptyLogin() {
		solo.clickOnButton(0);
		assertTrue(solo.waitForText("账号不能为空"));
		solo.sleep(1000);
		solo.enterText(0, "test111");
		solo.clickOnButton(0);
		assertTrue(solo.waitForText("密码不能为空"));
	}

	public void testBErrorLogin() {
		solo.enterText(0, "test1");
		solo.enterText(1, "111111");
		solo.clickOnButton(0);
		assertTrue(solo.waitForText("用户名或密码错误"));
	}

	public void testCCorrectLogin() {
		solo.enterText(0, "test1");
		solo.enterText(1, "888888");
		solo.clickOnButton(0);
		assertTrue(solo.waitForText("test1"));
	}

}
