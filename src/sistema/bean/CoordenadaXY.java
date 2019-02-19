/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.bean;

/**
 *
 * @author bruno
 */
public class CoordenadaXY{
        private int coordenadaX;
        private int coordenadaY;

        public CoordenadaXY() {
        }

        public int getCoordenadaX() {
            return coordenadaX;
        }

        public void setCoordenadaX(int coordenadaX) {
            this.coordenadaX = coordenadaX;
        }

        public int getCoordenadaY() {
            return coordenadaY;
        }

        public void setCoordenadaY(int coordenadaY) {
            this.coordenadaY = coordenadaY;
        }

        public CoordenadaXY(int coordenadaX, int coordenadaY) {
            this.coordenadaX = coordenadaX;
            this.coordenadaY = coordenadaY;
        }
    }
