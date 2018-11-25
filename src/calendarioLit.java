import java.applet.Applet;
import java.util.ArrayList;
import java.util.Date;

import processing.core.PApplet;

public class calendarioLit {
	private PApplet app;
	private String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	private int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private String[] weekDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	private int currentMonth;
	private int currentYear;
	private float plannerWidth;
	private float margin;
	private float topLabelMargin;
	private float calendarWidth;
	private float calendarHeight;
	private float spacing;

	public calendarioLit(PApplet app) {
		this.app = app;
		plannerWidth = 0;

		margin = 50;
		topLabelMargin = 100;
		calendarWidth = app.width - plannerWidth - (margin * 2);
		calendarHeight = app.height - (margin * 2) - topLabelMargin;
		spacing = 5;
		currentMonth = app.month() - 1;
		currentYear = app.year();
	}

	void pintar() {
		// Date Metrics
		String monthName = monthNames[currentMonth];
		int daysInMonth = monthDays[currentMonth];
		if (currentMonth == 1 && isLeapYear(currentYear))
			daysInMonth++;
		int dayOfMonth = -1;
		int dayOfWeek = -1;
		String dayOfWeekName = "";

		if (currentMonth == app.month() - 1 && currentYear == app.year()) {
			dayOfMonth = app.day();
			dayOfWeek = (new Date()).getDay();
			dayOfWeekName = weekDays[dayOfWeek];
		}

		Date date = new Date();
		date.setYear(currentYear);
		date.setMonth(currentMonth);
		date.setDate(1);

		int startingDayOfMonth = date.getDay(); // int(7 - (dayOfMonth % 7)); //NOT WORKING!
		String startingDayOfMonthName = weekDays[startingDayOfMonth];

		// Celendar Metrics
		int numRows = app.ceil((startingDayOfMonth + daysInMonth) / 7);
		margin = 50;
		topLabelMargin = 100;
		calendarWidth = app.width - plannerWidth - (margin * 2);
		calendarHeight = app.height - (margin * 2) - topLabelMargin;
		spacing = 5;
		float boxWidth = (calendarWidth - (6 * spacing)) / 7;
		float boxHeight = (calendarHeight - ((numRows - 1) * spacing)) / numRows;

		if (mouseInArrowRange()) {
			app.noStroke();

			if (mouseOverArrow(-1) || mouseOverArrow(-2))
				app.fill(255);
			else
				app.fill(204);
			app.triangle((float) ((app.width - plannerWidth) / 2 - (app.width - plannerWidth) / 10 * 3.5),
					margin + topLabelMargin / 10 * 3,
					(app.width - plannerWidth) / 2 - (app.width - plannerWidth) / 10 * 3,
					margin + topLabelMargin / 10 * 2,
					(app.width - plannerWidth) / 2 - (app.width - plannerWidth) / 10 * 3,
					margin + topLabelMargin / 10 * 4);

			if (mouseOverArrow(1) || mouseOverArrow(2))
				app.fill(255);
			else
				app.fill(204);
			app.triangle((float) ((app.width - plannerWidth) / 2 + (app.width - plannerWidth) / 10 * 3.5),
					margin + topLabelMargin / 10 * 3,
					(app.width - plannerWidth) / 2 + (app.width - plannerWidth) / 10 * 3,
					margin + topLabelMargin / 10 * 2,
					(app.width - plannerWidth) / 2 + (app.width - plannerWidth) / 10 * 3,
					margin + topLabelMargin / 10 * 4);

			if (mouseOverArrow(-2))
				app.fill(255);
			else
				app.fill(204);
			app.triangle((float) ((app.width - plannerWidth) / 2 - (app.width - plannerWidth) / 10 * 4.1),
					margin + topLabelMargin / 10 * 3,
					(float) ((app.width - plannerWidth) / 2 - (app.width - plannerWidth) / 10 * 3.6),
					margin + topLabelMargin / 10 * 2,
					(float) ((app.width - plannerWidth) / 2 - (app.width - plannerWidth) / 10 * 3.6),
					margin + topLabelMargin / 10 * 4);

			if (mouseOverArrow(2))
				app.fill(255);
			else
				app.fill(204);
			app.triangle((float) ((app.width - plannerWidth) / 2 + (app.width - plannerWidth) / 10 * 4.1),
					margin + topLabelMargin / 10 * 3,
					(float) ((app.width - plannerWidth) / 2 + (app.width - plannerWidth) / 10 * 3.6),
					margin + topLabelMargin / 10 * 2,
					(float) ((app.width - plannerWidth) / 2 + (app.width - plannerWidth) / 10 * 3.6),
					margin + topLabelMargin / 10 * 4);
		}

		app.fill(255);
		app.stroke(204);
		app.textSize(42);

		app.text(monthName + " " + currentYear, (app.width - plannerWidth) / 2, margin + topLabelMargin / 10 * 3);

		app.fill(204);
		app.textSize(12);

		for (int i = 0; i < weekDays.length; i++)
			app.text(weekDays[i], margin + (spacing * i) + (boxWidth * i) + boxWidth / 2,
					margin + topLabelMargin / 10 * 7);

		app.line(margin, (float) (margin + topLabelMargin / 10 * 8.5), app.width - plannerWidth - margin,
				(float) (margin + topLabelMargin / 10 * 8.5));

		app.stroke(0);

		float xoff = startingDayOfMonth;
		float yoff = 0;
		for (int i = 0; i < daysInMonth; i++) {
			String curDayOfWeekName = weekDays[(int) xoff];

			float x = margin + (spacing * xoff) + (boxWidth * xoff);
			float y = margin + topLabelMargin + (spacing * yoff) + (boxHeight * yoff);

			app.noStroke();
			app.fill(51);

			app.rect(x + 3, y + 3, boxWidth, boxHeight);

			app.stroke(0);
			if ((i + 1) == dayOfMonth)
				app.fill(255);
			else
				app.fill(204);

			app.rect(x, y, boxWidth, boxHeight);

			app.fill(0);
			app.textSize(24);

			app.text(i + 1, x + boxWidth / 2, y + boxHeight / 2);

			app.textSize(9);

			xoff = (xoff + 1) % 7;
			if (xoff == 0)
				yoff++;
		}

		if (!isToday()) {
			if (overTodayButton())
				app.fill(255);
			else
				app.fill(204);
			app.textSize(12);

			app.text("Today", (app.width - plannerWidth) / 2, app.height - margin / 2);

			if (app.mousePressed && overTodayButton())
				goToToday();
		}

		app.noStroke();

		// if(overPlannerScroller() || pressedPlannerScroller) app.fill(255);
		// else app.fill(204);
		//
		// rect(width - plannerWidth - 10, margin + topLabelMargin + calendarHeight / 5,
		// 10, calendarHeight / 5 * 3);

		if (plannerWidth > 50) {
			app.fill(51);

			app.rect(app.width - plannerWidth + 3, margin + topLabelMargin + 3, plannerWidth - margin,
					app.height - margin * 2 - topLabelMargin);

			app.stroke(0);
			app.fill(204);

			app.rect(app.width - plannerWidth, margin + topLabelMargin, plannerWidth - margin,
					app.height - margin * 2 - topLabelMargin);
		}

		// if(!mousePressed) pressedPlannerScroller = false;
		// if(pressedPlannerScroller) plannerWidth = constrain(width - mouseX, 0, 350);
	}

	boolean mouseOverArrow(int arrow) {
		switch (arrow) {
		case -2:
			return (mouseInArrowRange()
					&& app.mouseX > ((app.width - plannerWidth) / 2 - (app.width - plannerWidth) / 10 * 4.1)
					&& (app.mouseX < (app.width - plannerWidth) / 2 - (app.width - plannerWidth) / 10 * 3.6));
		case -1:
			return (mouseInArrowRange()
					&& app.mouseX > ((app.width - plannerWidth) / 2 - (app.width - plannerWidth) / 10 * 3.5)
					&& (app.mouseX < (app.width - plannerWidth) / 2 - (app.width - plannerWidth) / 10 * 3));
		case 1:
			return (mouseInArrowRange()
					&& app.mouseX < ((app.width - plannerWidth) / 2 + (app.width - plannerWidth) / 10 * 3.5)
					&& (app.mouseX > (app.width - plannerWidth) / 2 + (app.width - plannerWidth) / 10 * 3));
		case 2:
			return (mouseInArrowRange()
					&& app.mouseX < ((app.width - plannerWidth) / 2 + (app.width - plannerWidth) / 10 * 4.1)
					&& (app.mouseX > (app.width - plannerWidth) / 2 + (app.width - plannerWidth) / 10 * 3.6));
		}

		return false;
	}

	boolean mouseInArrowRange() {
		return (app.mouseY > (margin + topLabelMargin / 10 * 2) && app.mouseY < (margin + topLabelMargin / 10 * 4));
	}

	boolean isLeapYear(int year) {
		if (year % 400 == 0)
			return true;
		else if (year % 100 == 0)
			return false;
		else if (year % 4 == 0)
			return true;
		else
			return false;
	}

	void mouse() {
		if (mouseInArrowRange()) {
			if (mouseOverArrow(-2))
				currentYear--;
			if (mouseOverArrow(-1)) {
				currentMonth--;
				if (currentMonth < 0) {
					currentYear--;
					currentMonth = 11;
				}
			}
			if (mouseOverArrow(1)) {
				currentMonth++;
				if (currentMonth > 11) {
					currentYear++;
					currentMonth = 0;
				}
			}
			if (mouseOverArrow(2))
				currentYear++;
		}

		// if(overPlannerScroller()) pressedPlannerScroller = true;
	}

	int getDayInMonth(int year, int month, int dayOfWeek, int num) {
		Date date = new Date();
		date.setYear(year);
		date.setMonth(month);
		date.setDate(1);

		int startingDayOfMonth = date.getDay();

		return 7 * (dayOfWeek > startingDayOfMonth ? num - 1 : num) + (dayOfWeek) - startingDayOfMonth;
	}

	int lastDayInMonth(int year, int month, int dayOfWeek) {
		int daysInMonth = monthDays[month];
		if (month == 1 && isLeapYear(year))
			daysInMonth++;

		Date date = new Date();
		date.setYear(year);
		date.setMonth(month);
		date.setDate(daysInMonth);

		int lastDayOfMonth = date.getDay();

		return daysInMonth - (lastDayOfMonth - dayOfWeek) - (dayOfWeek - 1 > lastDayOfMonth ? 7 : 0) - 1;
	}

	void goToToday() {
		currentYear = app.year();
		currentMonth = app.month() - 1;
	}

	boolean isToday() {
		return (currentYear == app.year() && currentMonth == app.month() - 1);
	}

	boolean overTodayButton() {
		app.textSize(12);
		float textWidth = 60;
		float textHeight = app.textAscent() + app.textDescent() + 20;

		return (app.mouseX > (app.width - plannerWidth) / 2 - textWidth / 2
				&& app.mouseX < (app.width - plannerWidth) / 2 + textWidth / 2
				&& app.mouseY > app.height - margin / 2 - textHeight / 2
				&& app.mouseY < app.height - margin / 2 + textHeight / 2);
	}

	boolean overPlannerScroller() {
		return (app.mouseY > margin + topLabelMargin && app.mouseY < margin + topLabelMargin + calendarHeight
				&& app.mouseX > app.width - plannerWidth - 15 && app.mouseX < app.width - plannerWidth + 5);
	}

}
