package com.softserve.edu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.controls.Component;
import com.softserve.edu.atqc.tools.controls.IComponent;
import com.softserve.edu.atqc.tools.controls.ILabel;
import com.softserve.edu.atqc.tools.controls.ILabelClickable;
import com.softserve.edu.atqc.tools.controls.ILink;
import com.softserve.edu.atqc.tools.controls.Label;
import com.softserve.edu.atqc.tools.controls.Link;
import com.softserve.edu.atqc.tools.search.ByWrapper;
import com.softserve.edu.atqc.tools.search.ImplicitWrapper;

public class AdminHomePage  {
	private class AdminHomePageUIMap {
		private ILabel pageHeader;
		private IComponent leftSideBar;
		private ILink organizationTabLink;
		private ILink logoutLink;
		private ILink logoutDropDown;
		
		public AdminHomePageUIMap(){
			this.pageHeader = Label.get().getByXpath(".//*[@id='page-wrapper']/div[1]/div/h1");
			this.leftSideBar = Component.get().getById("side-menu");
			this.organizationTabLink = Link.get().getByXpath(".//*[@id='side-menu']/li[2]/a");
			
			
			this.logoutDropDown = Link.get().getByXpath(".//*[@id='adminModule']/nav/ul/li");
			this.logoutLink = Link.get().getByXpath(".//*[@id='adminModule']/nav/ul/li/ul/li[2]/div[3]/a");
		}
		
	}
    AdminHomePageUIMap controls;
	public AdminHomePage() {
      this.controls = new AdminHomePageUIMap();
				
	}

	public void organizationTabLinkClick() {
		this.controls.organizationTabLink.click();
	}

	public ILabel getPageHeader() {
		return this.controls.pageHeader;
	}

	public IComponent getLeftSideBar() {
		return this.controls.leftSideBar;
	}

	public String getPageHeaderText() {
		return getPageHeader().getText();
	}

	public MainPage logOut()  {
		
		controls.logoutDropDown.click();
		
		controls.logoutLink.click();
		return new MainPage();
	}

	public OrganizationPage gotoOrganizationPage() {
		organizationTabLinkClick();
		return new OrganizationPage();

	}
}
