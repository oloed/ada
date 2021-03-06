package com.divisiblebyzero.chess.pieces;

import com.divisiblebyzero.chess.Bitboard;
import com.divisiblebyzero.chess.Piece;

public class King extends Piece {
    private static final long serialVersionUID = 8277991081370155149L;

    public static long getAttackBitmap(long[][] bitboard, Piece piece) {
        long bitmap = Bitboard.getBitmapAtPosition(bitboard, piece.getPosition());
        long result = 0;
        
        /* The squares directly above, and below, the King. */
        result = result | (bitmap << 8) | (bitmap >>> 8);
        
        /* The three squares to the right of the King. */
        result = result | ((bitmap <<  1) & ~Bitboard.getFile(Bitboard.File.A));
        result = result | ((bitmap <<  9) & ~Bitboard.getFile(Bitboard.File.A));
        result = result | ((bitmap <<  7) & ~Bitboard.getFile(Bitboard.File.H));
        
        /* The three squares to the left of the King. */
        result = result | ((bitmap >>> 1) & ~Bitboard.getFile(Bitboard.File.H));
        result = result | ((bitmap >>> 9) & ~Bitboard.getFile(Bitboard.File.H));
        result = result | ((bitmap >>> 7) & ~Bitboard.getFile(Bitboard.File.A));
        
        return result;
    }
}
