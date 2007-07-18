package com.divisiblebyzero.chess.model;

//
//  chess.models.Piece.java
//  Ada Chess
//
//  Created by Eric Czarny on February 27, 2006.
//  Copyright 2006 Divisible by Zero. All rights reserved.
//

import java.awt.*;

import com.divisiblebyzero.utilities.*;

public class Piece {
	private Image image;
	private Position position;
	private int color;
	private int type;

	/* Constants for piece resources */
	private static final String EXTENSION = ".png";
	private static final String PATH      = "/images/pieces/";
	private static final String STYLE     = "motif";

	/* Possible piece types */
	public static final int KING   = 0;
	public static final int QUEEN  = 1;
	public static final int ROOK   = 2;
	public static final int BISHOP = 3;
	public static final int KNIGHT = 4;
	public static final int PAWN   = 5;

	/*Possible piece colors */
	public static final int BLACK = 0;
	public static final int WHITE = 1;

	public Piece() {
		this.position = null;
		this.color    = -1;
		this.type     = -1;
	}

	public Piece(Position position) {
		this.position = position;
		this.color    = -1;
		this.type     = -1;
	}

	public Piece(int color, int type) {
		this.position = null;
		this.color    = color;
		this.type     = type;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getColor() {
		return this.color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Image getImage() {
		if (this.image == null) {
			this.image = this.getImage(STYLE, this.getIdentifier());
		}

		return this.image;
	}

	private String getIdentifier() {
		return (String.valueOf((char)(66 + ((this.color * 20) + (this.color * 1)))) + String.valueOf(this.type));
	}

	private Image getImage(String style, String identifier) {
		return Resource.getImage(this.getImagePath(style, identifier));
	}

	private String getImagePath(String style, String identifier) {
		return PATH + style + "/" + identifier + EXTENSION;
	}
}