/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 *
 * @author ivans
 */
public abstract class Animal {

    /**
     *
     */
    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;

    /**
     * Constructor de la clase Animal.
     * Crea un nuevo objeto Animal con un código identificativo, fecha de nacimiento, sexo y peso.
     * Realiza validaciones sobre los parámetros:
         * El código debe tener exactamente 5 caracteres que sean dígitos (0-9) o letras minúsculas (a-z)
         * El sexo debe ser 'M' (hembra) o 'H' (macho).
         * El peso debe ser un valor positivo mayor que cero.
         * La fecha de nacimiento debe estar en formato ISO-8601 (yyyy-MM-dd) válido.
     * @param codigo
     * @param fechaNacimiento la fecha de nacimiento del animal en formato "yyyy-MM-dd"
     * @param sexo el sexo del animal, 'M' para hembra o 'H' para macho
     * @param peso el peso del animal en kilogramos, debe ser mayor que 0
     * 
     * @throws IllegalArgumentException  si el código no cumple el patrón, el sexo es incorrecto, el peso no es positivo o la fecha no tiene un formato válido
     */
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) {

        LocalDate fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {

            try {
                fecha = LocalDate.parse(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException();
            }
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.sexo = sexo;
            this.peso = peso;
        }
    }

    /**
     * Obtiene el código identificativo del animal.
     * @return el código identificativo del animal
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código identificativo del animal.
     * El código debe estar compuesto por exactamente
     * 5 caracteres alfanuméricos en minúscula.
     * @param codigo nuevo código identificativo del animal
     *  @throws IllegalArgumentException si el código no cumple el formato permitido
     */
    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

    /**
     * Obtiene la fecha de nacimiento del animal.
     * @return la fecha de nacimiento del animal
     * 
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del animal.
     * La fecha debe tener un formato ISO-8601 válido (yyyy-MM-dd). 
     * 
     * @param fechaNacimiento nueva fecha de nacimiento del animal.
     * @throws IllegalArgumentException si la fecha no tiene un formato valido.
     * 
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }

        this.fechaNacimiento = fecha;
    }

    /**
     * Obtiene el sexo del animal.
     * @return el sexo del animal: Macho (M) o Hembra (H).
     * 
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del animal.
     * El sexo debe ser:
     * @param sexo nuevo sexo del animal
     * @throws IllegalArgumentException si el sexo no es válido
     * 
     */
    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }

    /**
     * Obtiene el peso del animal.
     * 
     * @return el peso del animal en kilogramos
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso del animal.
     * @param peso nuevo peso del animal en kilogramos
     * @throws IllegalArgumentException si el peso no es positivo
     * 
     */
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }

    /**
     * Genera y devuelve el código hash del objeto.
     *
     * @return el código hash generado para el objeto
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

    /**
     * Comprueba si este objeto es igual a otro.
     *
     * Dos animales serán iguales si tienen el mismo código,
     * fecha de nacimiento, sexo y peso.
     *
     * @param obj objeto con el que se compara
     *
     * @return true si ambos objetos son iguales;
     *         false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación textual del objeto Animal.
     *
     * @return una cadena con los datos del animal
     */
    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }
   
    /**
     * Produce el sonido característico del animal.
     *
     * @return el sonido que realiza el animal
     */
    public abstract String hacerSonido();

    /**
     * Expresa el comportamiento del animal cuando está alegre.
     *
     * @return una representación del comportamiento alegre
     *         del animal
     */
    public abstract String alegrarse();

    /**
     * Expresa el comportamiento del animal cuando está enfadado.
     *
     * @return una representación del comportamiento enfadado
     *         del animal
     */
    public abstract String enfadarse();

    /**
     * Indica el tipo de animal.
     *
     * @return el tipo o especie del animal
     */
    public abstract String queSoy();

}
