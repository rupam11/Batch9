package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.training.generics.ScreenShot;
import com.training.pom.CourseAssessmentPOM;
import com.training.pom.CourseAssignmentPOM;
import com.training.pom.CourseCatalogPOM;
import com.training.pom.CourseForumGroupPOM;
import com.training.pom.CourseForumPOM;
import com.training.pom.CourseGrpGroupPOM;
import com.training.pom.CreateCoursePOM;
import com.training.pom.CreateNewTestPOM;
import com.training.pom.GroupType1POM;
import com.training.pom.GrpGroupType1POM;
import com.training.pom.InitiateNewTestPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LostPwdPOM;
import com.training.pom.MyCoursesPOM;
import com.training.pom.ProfilePOM;
import com.training.pom.ReportingPOM;
import com.training.pom.StudentActPOM;
import com.training.pom.TestResultPOM;
import com.training.pom.TestType1POM;
import com.training.pom.UploadAssignmentPOM;
import com.training.pom.CourseHomePOM;
import com.training.pom.CourseInfoPOM;
import com.training.pom.CourseTestPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {
	
	private WebDriver driver;
	private String baseUrl;
	public LoginPOM loginPOM;
	public ProfilePOM profilePOM;
	public LostPwdPOM lostPwdPOM;
	public MyCoursesPOM myCoursePOM;
	public CourseCatalogPOM courseCatLogPOM;
	public CreateCoursePOM createCoursePOM;
	public CourseHomePOM studCourseOptPOM,courseHomePOM;
	public CourseInfoPOM courseInfoPOM;
	public CourseTestPOM courseTestPOM;
	public TestType1POM testType1POM;
	public TestResultPOM testResultPOM;
	public CourseAssessmentPOM courseAssessPOM;
	public CourseAssignmentPOM courseAssignmentPOM;
	public UploadAssignmentPOM uploadAssignmentPOM;
	public CourseForumGroupPOM courseForumGrpPOM;
	public CourseGrpGroupPOM courseGrpGrpPOM;
	public GroupType1POM groupType1POM;
	public GrpGroupType1POM grpGroupType1POM;
	public InitiateNewTestPOM intNewTestPOM;
	public CreateNewTestPOM createNewTestPOM;
	public ReportingPOM reportPOM;
	public StudentActPOM studActPOM;
	public static Properties properties;
	public ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		System.out.println("inside superclass login test before class");
		properties = new Properties();		
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		profilePOM = new ProfilePOM(driver);
		lostPwdPOM = new LostPwdPOM(driver);
		myCoursePOM=new MyCoursesPOM(driver);
		courseCatLogPOM=new CourseCatalogPOM(driver);
		createCoursePOM=new CreateCoursePOM(driver);
		studCourseOptPOM=new CourseHomePOM(driver);
		courseInfoPOM=new CourseInfoPOM(driver);
		courseHomePOM=new CourseHomePOM(driver);
		courseTestPOM=new CourseTestPOM(driver);
		testType1POM=new TestType1POM(driver);
		testResultPOM=new TestResultPOM(driver);
		courseAssessPOM=new CourseAssessmentPOM(driver);
		courseAssignmentPOM=new CourseAssignmentPOM(driver);
		uploadAssignmentPOM=new UploadAssignmentPOM(driver);
		courseForumGrpPOM=new CourseForumGroupPOM(driver);
		courseGrpGrpPOM=new CourseGrpGroupPOM(driver);
		groupType1POM=new GroupType1POM(driver);
		grpGroupType1POM=new GrpGroupType1POM(driver);
		intNewTestPOM=new InitiateNewTestPOM(driver);
		createNewTestPOM=new CreateNewTestPOM(driver);
		reportPOM=new ReportingPOM(driver);
		studActPOM=new StudentActPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	 public void validLoginTest() {
	 loginPOM.sendUserName("teach_usernm");
	 loginPOM.sendPassword("pass#123");
	 loginPOM.clickLoginBtn();
	 screenShot.captureScreenShot("validLoginTest");
	 }
	 
	 public void validLoginTest(String user) {
		if(user.equalsIgnoreCase("teach_usernm"))
		{
			loginPOM.sendUserName(properties.getProperty("TUserNm"));	
			loginPOM.sendPassword(properties.getProperty("TPwd"));
		}
		else if(user.equalsIgnoreCase("admin")) 
		{
			loginPOM.sendUserName(properties.getProperty("AUserNm"));	
			loginPOM.sendPassword(properties.getProperty("APwd"));
		}
		else {
			loginPOM.sendUserName(properties.getProperty("SUserNm"));	
			loginPOM.sendPassword(properties.getProperty("SPwd"));
		}
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("validLoginTest");		
		}
	
}

