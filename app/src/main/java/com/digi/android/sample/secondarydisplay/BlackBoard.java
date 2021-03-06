/**
 * Copyright (c) 2014-2016, Digi International Inc. <support@digi.com>
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.digi.android.sample.secondarydisplay;

import android.app.Presentation;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

class BlackBoard extends Presentation {

	// Constants.
	private final static int SIZE_SMALL = 0;
	private final static int SIZE_MEDIUM = 1;
	private final static int SIZE_BIG = 2;
	private final static int SIZE_GIANT = 3;
	
	private final static int COLOR_WHITE = 0;
	private final static int COLOR_BLUE = 1;
	private final static int COLOR_GREEN = 2;
	private final static int COLOR_YELLOW = 3;
	private final static int COLOR_RED = 4;
	
	private final static float SMALL_DP = 50.0f;
	private final static float MEDIUM_DP = 80.0f;
	private final static float BIG_DP = 120.0f;
	private final static float GIANT_DP = 160.0f;
	
	private TextView displayText;
	
	private final Context context;
	
	/**
	 * Class constructor. Instances a new BlackBoard object with the given parameters.
	 * 
	 * @param outerContext Context to use for this BlackBoard.
	 * @param display Display to draw BlackBoard in.
	 */
	public BlackBoard(Context outerContext, Display display) {
		super(outerContext, display);
		context = outerContext;
	}
	
	/**
	 * Changes the display text value.
	 * 
	 * @param newText The new text value.
	 */
	public void setText(String newText) {
		displayText.setText(newText);
	}
	
	/**
	 * Clears the display text.
	 */
	public void clearText() {
		displayText.setText("");
	}
	
	/**
	 * Changes the text visibility with the new value.
	 * 
	 * @param visible True to make text visible, false otherwise.
	 */
	public void setTextVisible(boolean visible) {
		if (visible)
			displayText.setVisibility(View.VISIBLE);
		else
			displayText.setVisibility(View.GONE);
	}
	
	/**
	 * Changes the text size based on the given value.
	 * 
	 * @param size New text size.
	 */
	public void setTextSize(int size) {
		float fontSize;
		switch (size) {
			case SIZE_SMALL:
				fontSize = SMALL_DP;
				break;
			case SIZE_MEDIUM:
				fontSize = MEDIUM_DP;
				break;
			case SIZE_BIG:
				fontSize = BIG_DP;
				break;
			case SIZE_GIANT:
				fontSize = GIANT_DP;
				break;
			default:
				fontSize = MEDIUM_DP;
				break;
		}
		displayText.setTextSize(fontSize);
	}
	
	/**
	 * Changes the text color based on the given value.
	 * 
	 * @param color New text color.
	 */
	public void setTextColor(int color) {
		switch (color) {
			case COLOR_WHITE:
				displayText.setTextColor(getResources().getColor(R.color.white));
				break;
			case COLOR_BLUE:
				displayText.setTextColor(getResources().getColor(R.color.light_blue));
				break;
			case COLOR_GREEN:
				displayText.setTextColor(getResources().getColor(R.color.light_green));
				break;
			case COLOR_YELLOW:
				displayText.setTextColor(getResources().getColor(R.color.light_yellow));
				break;
			case COLOR_RED:
				displayText.setTextColor(getResources().getColor(R.color.light_red));
				break;
			default:
				displayText.setTextColor(getResources().getColor(R.color.white));
				break;
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set content view.
		setContentView(R.layout.secondary_display);
		// Initialize UI Components.
		initializeUIComponents();
	}

	/**
	 * Initializes all the UI components and event listeners.
	 */
	private void initializeUIComponents() {
		displayText = (TextView)findViewById(R.id.blackboard_text);
		setTextSize(SIZE_MEDIUM);
		setTextColor(COLOR_WHITE);
		setTextVisible(true);
		Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/blackboardultra.otf");
		displayText.setTypeface(type);
	}
}
