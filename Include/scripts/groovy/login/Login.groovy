package login
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Login {
	@Given("User berada dihalaman login")
	public void user_berada_dihalaman_login() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('http://www.saucedemo.com/')
	}

	@When("User masukkan username")
	public void user_masukkan_username() {
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_user-name'), "standard_user")
	}

	@When("User masukkan password")
	public void user_masukkan_password() {
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_password'), "secret_sauce")
	}

	@When("User menekan tombol login")
	public void user_menekan_tombol_login() {
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_login-button'), null)
	}

	@Then("User berada di halaman home web")
	public void user_berada_di_halaman_home_web() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/span_Products'), 0)
	}
	
	@When("User masukkan username yang salah")
	public void user_masukkan_username_yang_salah() {
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_user-name'), "salah")
	}

	@When("User masukkan password yang salah")
	public void user_masukkan_password_yang_salah() {
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_password'), "123")
	}
	
	@Then("User tidak bisa login")
	public void user_tidak_bisa_login() {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Swag Labs/span_Products'), 0)
	}
	
	@Given("User berada di homepage")
	public void user_berada_di_homepage() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('http://www.saucedemo.com/')
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_user-name'), "standard_user")
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_password'), "secret_sauce")
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_login-button'), null)
	}
	
	@When("User masukkan barang ke keranjang")
	public void user_masukkan_barang_ke_keranjang() {
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Add to cart'))
	}
	
	@When("User menekan tombol keranjang")
	public void user_menekan_tombol_keranjang() {
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/a_1'))
	}
	
	@When("User menekan tombol checkout")
	public void user_menekan_tombol_checkout() {
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Checkout'))
	}
	
	@When("User memasukkan data pemesan")
	public void user_memasukkan_data_pemesan() {
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Checkout Your Information_firstName'), "Arif")
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Checkout Your Information_lastName'), "Pebriansyah")
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Checkout Your Information_postalCode'), "123")
	}
	
	@When("User menekan tombol continue")
	public void user_menekan_tombol_continue() {
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Cancel_continue'))
	}
	
	@When("User menekan tombol finish")
	public void user_menekan_tombol_finish() {
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/Finish'))
	}
	
	@Then("User berhasil memesan")
	public void user_berhasil_memesan() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/h2_Thank you for your order'), 0)
	}
	
	@And("User menekan tombol remove")
	public void user_menekan_tombol_remove() {
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Remove'))
	}
	
	@Then("User berhasil hapus barang")
	def user_berhasil_hapus_barang() {
		WebUI.verifyTextNotPresent("Sauce Labs Backpack", false)
	}
}