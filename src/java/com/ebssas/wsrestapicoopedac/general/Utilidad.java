/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.general;

import com.ebssas.wsrestapicoopedac.domain.Parametros;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

/**
 *
 * @author Brayan F Silva R
 */
public class Utilidad {

    private static final Locale localeCO = new Locale("es", "CO");

    private static final SimpleDateFormat dateFormatDiaMesAnio = new SimpleDateFormat("dd/MM/yyyy", localeCO);
    private static final SimpleDateFormat dateFormatMesDiaAnio = new SimpleDateFormat("MM/dd/yyyy", localeCO);
    private static final SimpleDateFormat sdfFechaHora = new SimpleDateFormat("dd/MMMM/yyyy HH:mm:ss", localeCO);
    private static final SimpleDateFormat dateFormatAnioMesDia = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", localeCO);
    InputStream inputStream;

    
    public Utilidad() {
    }

    public String curdate() {
        return this.dateToStringFormatFechaHora(new Date());
    }

    public String generarAleatorio(int cant) throws Exception {
        Random generadorAleatorios = new Random();
        String result = "";
        int numeroAleatorio;

        for (int i = 1; i <= cant; i++) {
            numeroAleatorio = 1 + generadorAleatorios.nextInt(9);
            result += numeroAleatorio;
        }

        return result;
    }

    public long generarLlave(int canDigitos) {
        long intNumber = 1;
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(canDigitos);
        intNumber = Long.parseLong(format.format(intNumber).replace(",", ""));
        long num = (long) (intNumber * Math.random());
        return num;
    }

    public Date obtenerFechaFinalAcceso(Date fecha, int dias) {
        Calendar calen = Calendar.getInstance();
        calen.setTime(fecha);
        calen.add(Calendar.DAY_OF_YEAR, dias);
        return calen.getTime();
    }

    public Date getDateAddMinutos(Date dateInicio, int iMinutos) {
        Calendar calen = Calendar.getInstance();
        calen.setTime(dateInicio);
        calen.add(Calendar.MINUTE, iMinutos);
        return calen.getTime();
    }

    public ArrayList<String> contrasenaRandom(int cantC, String cantSalt) throws Exception {
        EncriptarSha xtran = new EncriptarSha();
        ArrayList lista = new ArrayList();

        int nRand, lMunRand, lMayRand, numRand;
        String contra = "", passSha;
        ArrayList array = new ArrayList();
        boolean flag = false;

        String numeros[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String lMinusculas[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String lMayusculas[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String total[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        nRand = (int) Math.round(Math.random() * (numeros.length - 1));
        lMunRand = (int) Math.round(Math.random() * (lMinusculas.length - 1));
        lMayRand = (int) Math.round(Math.random() * (lMayusculas.length - 1));

        String vecTemp[] = {numeros[nRand], lMinusculas[lMunRand], lMayusculas[lMayRand]};

        for (int i = 0; i < cantC; i++) {
            if (i < vecTemp.length) {
                while (flag == false) {
                    numRand = (int) Math.round(Math.random() * (vecTemp.length - 1));
                    if (array.indexOf(numRand) == -1) {
                        contra += vecTemp[numRand];
                        array.add(numRand);
                        flag = true;
                    } else {
                        flag = false;
                    }
                }
            } else {
                numRand = (int) Math.round(Math.random() * (total.length - 1));
                contra += total[numRand];
            }

            flag = false;
        }
        passSha = xtran.encriptar(contra, cantSalt);

        lista.add(contra);
        lista.add(passSha);

        return lista;
    }

    public String passwordRandom(int maxPassword) throws Exception {
        int nRand, lMunRand, lMayRand, numRand;
        String contra = "";
        ArrayList array = new ArrayList();
        boolean flag = false;

        String numeros[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String lMinusculas[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String lMayusculas[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String total[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        nRand = (int) Math.round(Math.random() * (numeros.length - 1));
        lMunRand = (int) Math.round(Math.random() * (lMinusculas.length - 1));
        lMayRand = (int) Math.round(Math.random() * (lMayusculas.length - 1));

        String vecTemp[] = {numeros[nRand], lMinusculas[lMunRand], lMayusculas[lMayRand]};

        for (int i = 0; i < maxPassword; i++) {
            if (i < vecTemp.length) {
                while (flag == false) {
                    numRand = (int) Math.round(Math.random() * (vecTemp.length - 1));
                    if (array.indexOf(numRand) == -1) {
                        contra += vecTemp[numRand];
                        array.add(numRand);
                        flag = true;
                    } else {
                        flag = false;
                    }
                }
            } else {
                numRand = (int) Math.round(Math.random() * (total.length - 1));
                contra += total[numRand];
            }

            flag = false;
        }
        return contra;
    }

    public String ocultarCorreo(String correo) {
        int p1, div2;
        String cadena1, xVar = "", cadena2, cadena3, cadena4;
        p1 = correo.indexOf("@");
        cadena1 = correo.substring(0, p1);
        int tam1 = 0;
        tam1 = cadena1.length();
        div2 = (tam1 / 3) + 1;
        cadena2 = cadena1.substring(0, div2 - 1);
        for (int i = 0; i < div2; i++) {
            xVar += "x";
        }
        cadena3 = cadena2 + xVar;
        cadena4 = cadena3 + correo.substring(cadena3.length(), correo.length());

        return cadena4;
    }

    public String ocultarTelefono(String correo) {
        int div2;
        String cadena1, xVar = "", cadena2, cadena3, cadena4;
        cadena1 = correo.substring(0, 6);
        int tam1 = 0;
        tam1 = cadena1.length();
        div2 = (tam1 / 3) + 1;
        cadena2 = cadena1.substring(0, div2 - 1);
        for (int i = 0; i < div2; i++) {
            xVar += "x";
        }
        cadena3 = cadena2 + xVar;
        cadena4 = cadena3 + correo.substring(cadena3.length(), correo.length());

        return cadena4;
    }

    public String capitalizarFrase(String cadena) {
        cadena = cadena.toLowerCase();
        String[] splitCadena = cadena.split(" ");
        String fraseCapitalizada = "";

        for (int i = 0; i < splitCadena.length; i++) {
            String primeraLetra = splitCadena[i].substring(0, 1).toUpperCase();
            String restoDeLaCadena = splitCadena[i].substring(1);
            if (splitCadena.length == 1 || i == 0) {
                fraseCapitalizada += primeraLetra + restoDeLaCadena;
            } else {
                fraseCapitalizada += " ";
                fraseCapitalizada += primeraLetra + restoDeLaCadena;
            }
        }
        return fraseCapitalizada;
    }

    public String encodeBase64(String sParEncode) {
        String rtaEncode64 = "";
        rtaEncode64 = Base64.getEncoder().encodeToString(sParEncode.getBytes());
        return rtaEncode64;
    }

    public String decodeBase64(String sParDecode) {
        String rtadecode64 = "";
        byte[] decodedBytes = Base64.getDecoder().decode(sParDecode);
        rtadecode64 = new String(decodedBytes);
        return rtadecode64;
    }

    public String getHash(String txt, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public String nonceGenerator() {
        return new BigInteger(130, new SecureRandom()).toString();
    }

    public Date getDateAdd(int dias) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String sDateStamp;
        String hora, minutos, segundos;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(calendar.getTime()); // Configuramos la fecha que se recibe

        hora = (calendar.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) : String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)));
        minutos = (calendar.get(Calendar.MINUTE) < 10 ? "0" + String.valueOf(calendar.get(Calendar.MINUTE)) : String.valueOf(calendar.get(Calendar.MINUTE)));
        segundos = (calendar.get(Calendar.SECOND) < 10 ? "0" + String.valueOf(calendar.get(Calendar.SECOND)) : String.valueOf(calendar.get(Calendar.SECOND)));

        calendar.add(Calendar.DAY_OF_YEAR, dias);
        sDateStamp = formatTime(calendar.get(Calendar.DATE)) + "/" + formatTime(calendar.get(Calendar.MONTH) + 1) + "/" + formatTime(calendar.get(Calendar.YEAR)) + " " + hora + ":" + minutos + ":" + segundos;
        Date dateAddDays = dateFormat.parse(sDateStamp);
        return dateAddDays;
    }

    private String formatTime(int time) {
        String timeStr;
        if (time < 10) {
            timeStr = "0" + time;
        } else {
            timeStr = "" + time;
        }
        return timeStr;
    }

    public String getIp() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();

        byte[] bIPAddress = address.getAddress();
        String sIPAddress = "";
        for (int x = 0; x < bIPAddress.length; x++) {
            if (x > 0) {
                sIPAddress += ".";
            }
            sIPAddress += bIPAddress[x] & 255;
        }
        return sIPAddress;
    }

    public String getHost() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        return address.getHostName();
    }

    public String getYear() {
        String sDateStamp;
        Calendar calendar = Calendar.getInstance();
        sDateStamp = formatTime(calendar.get(Calendar.YEAR));
        //devolvemos la cadena
        return sDateStamp;
    }

    public String getMonth() {
        String sDateStamp;
        Calendar calendar = Calendar.getInstance();
        sDateStamp = formatTime(calendar.get(Calendar.MONTH));
        //devolvemos la cadena
        return sDateStamp;
    }

    public String getPrimerDiaMes() {
        String sFecha = "";
        //Fecha Actual
        Calendar calendar = Calendar.getInstance();
        //A la fecha actual le pongo el d√≠a 1
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        sFecha = dateFormatDiaMesAnio.format(calendar.getTime());
        return sFecha;
    }

    public String TokenRandom(int maxPassword) throws Exception {
        int nRand, lMunRand, lMayRand, numRand;
        String contra = "";
        ArrayList array = new ArrayList();
        boolean flag = false;

        String numeros[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String lMinusculas[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String lMayusculas[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String total[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        nRand = (int) Math.round(Math.random() * (numeros.length - 1));
        lMunRand = (int) Math.round(Math.random() * (lMinusculas.length - 1));
        lMayRand = (int) Math.round(Math.random() * (lMayusculas.length - 1));

        String vecTemp[] = {numeros[nRand]};

        for (int i = 0; i < maxPassword; i++) {
            if (i < maxPassword) {
                numRand = (int) (1 + (Math.random() * 9));
                contra += numRand;
            }
            flag = false;
        }
        return contra;
    }

    public String getUltimoDiaMes() {
        String sFecha = "";
        Calendar calFin = Calendar.getInstance();
        int iCurrentMonth = Integer.parseInt(this.getMonth());
        int iYear = 0;
        iYear = Integer.parseInt(this.getYear());
        calFin.set(iYear, iCurrentMonth, calFin.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date dateCorteMes = calFin.getTime();
        sFecha = dateFormatDiaMesAnio.format(dateCorteMes);
        return sFecha;
    }

    public String getUltimoDiaMesAnterior() {
        String sFecha = "";
        Calendar calFin = Calendar.getInstance();
        int iCurrentMonth = Integer.parseInt(this.getMonth());
        int iYear = 0;
        if (iCurrentMonth == 00) {
            iYear = Integer.parseInt(this.getYear()) - 1;
        } else {
            iYear = Integer.parseInt(this.getYear());
        }
        calFin.set(iYear, iCurrentMonth - 1, 1);
        calFin.set(iYear, iCurrentMonth - 1, calFin.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date dateCorteMes = calFin.getTime();
        sFecha = dateFormatDiaMesAnio.format(dateCorteMes);
        return sFecha;
    }

    public boolean verificarAlfanumerico(String xClave, int digMin, int digMax) {
        boolean rta = false;
        boolean numerico = false;
        boolean mayuscula = false;
        boolean minuscula = false;
        boolean minimo = false;
        boolean maximo = false;
        if (xClave.length() >= digMin) {
            minimo = true;
        }
        if (xClave.length() <= digMax) {
            maximo = true;
        }
        char[] letras = xClave.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            if (Character.isDigit(letras[i])) {
                numerico = true;
            }
            if (Character.isUpperCase(letras[i])) {
                mayuscula = true;
            }
            if (Character.isLowerCase(letras[i])) {
                minuscula = true;
            }
        }
        if (numerico && mayuscula && minuscula && minimo && maximo) {
            rta = true;
        }
        return rta;
    }

    public String dateToStringFormatFechaHora(Date date) {
        String sFechaFormat = "";
        sFechaFormat = sdfFechaHora.format(date);
        return sFechaFormat.toUpperCase();
    }

    public String dateToStringFormatFecha(Date date) {
        String sFechaFormat = "";
        sFechaFormat = dateFormatDiaMesAnio.format(date);
        return sFechaFormat.toUpperCase();
    }

    public String dateToStringFormatFechaMesDiaAnio(Date date) {
        String sFechaFormat = "";
        sFechaFormat = dateFormatMesDiaAnio.format(date);
        return sFechaFormat.toUpperCase();
    }

    public String dateToStringFormatFechaNumRadicSolCred(String sFormat) {
        SimpleDateFormat dateFormatAnioMesDia = new SimpleDateFormat(sFormat);
        String sFechaFormat = "";
        sFechaFormat = dateFormatAnioMesDia.format(new Date());
        return sFechaFormat.toUpperCase();
    }

    public String dateToStringFormatFechaNumRadicSolPagare(String sFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(sFormat);
        String sFechaFormat = "";
        sFechaFormat = dateFormat.format(new Date());
        return sFechaFormat.toUpperCase();
    }

    public Date stringToDateAnioMesDia(String sFecha) {
        Date date = new Date();
        try {
            String sFechaTemp = sFecha.substring(0, 18);
            date = dateFormatAnioMesDia.parse(sFechaTemp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public String valorPattern(String monto) throws ParseException {
        String sValorPattern;
        String pattern = "###,###.00";
        DecimalFormat df = new DecimalFormat();
        df.applyPattern(pattern);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(',');
        df.setDecimalFormatSymbols(symbols);
        double dMonto = df.parse(monto).doubleValue();
        BigDecimal bdMonto = new BigDecimal(dMonto);
        bdMonto = bdMonto.setScale(2, RoundingMode.HALF_UP);
        sValorPattern = df.format(bdMonto);
        return sValorPattern;
    }

    public String getValueConfigurePropByKey(String sKey) {
        String result = "";

        try {
            Properties prop = new Properties();
            String propFileName = "/com/ebssas/wsrestapicoopedac/general/configure.properties";
            URL url = getClass().getResource(propFileName);

            inputStream = url.openStream();

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            result = prop.getProperty(sKey);

        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        return result;
    }

    public Parametros findParam(List<Parametros> lista, String cNombre) {
        Parametros resultado = null;

        for (Parametros p : lista) {
            if (p.getCNombre().equals(cNombre)) {
                resultado = p;
                break;
            }
        }

        return resultado;
    }

    public String calcularFechaLinaCredito(String date, int linea) {
        String sFechaSol = date;
        int pwsCodCredi = linea;

//        System.out.println("Fecha actual-->" + date);
        String[] partsFecha = sFechaSol.split("/");

        int mes = Integer.parseInt(partsFecha[0]);
        int dia = Integer.parseInt(partsFecha[1]);
        int anio = Integer.parseInt(partsFecha[2]);

//        System.out.println("dia-->" + dia);
//        System.out.println("mes-->" + mes);
//        System.out.println("aÒoo" + anio);
        Calendar cal = Calendar.getInstance();

        int res = 0;

        if (pwsCodCredi == 504) {
//            System.out.println("linea semestral");
            if (mes >= 1 && mes <= 5) {
                cal.set(anio, 11, dia);
                res = cal.getActualMaximum(Calendar.DATE);
                sFechaSol = "01" + "/10/" + (anio);
            } else if (mes >= 7 && mes <= 11) {
                if ((mes == 7 && dia <= 15)||(mes == 11 && dia >= 16)) {
//                    alerta que diga linea no disponible
                    sFechaSol="Linea no disponible";
                }else{
                    cal.set(anio, 5, dia);
                    res = cal.getActualMaximum(Calendar.DATE);
                    sFechaSol = "06" + "/10/" + anio;
                }
            } else if (mes == 6) {
                if (dia <= 15) {
                    sFechaSol = "01" + "/10/" + (anio);
                } else {
                    sFechaSol="Linea no disponible";
//                    sFechaSol = "06" + "/10/" + anio;
                }
            } else if (mes == 12) {
                if (dia <= 14) {
                    sFechaSol="Linea no disponible";
//                    sFechaSol = "06" + "/15/" + (anio);
                } else {
                    sFechaSol = "01" + "/10/" + anio +1;
                }
            }
//            System.out.println("nuevaFecha" + sFechaSol);
        } else if (pwsCodCredi == 900) {
//            System.out.println("linea bimensual");
            if (mes % 2 == 0) {
//                 System.out.println("mes parr");
                cal.set(anio, (mes - 1), dia);
                res = cal.getActualMaximum(Calendar.DATE);
                sFechaSol = "0" + mes + "/" + res + "/" + (anio);
            } else {
//                System.out.println("mes imparrrr"+mes);
                cal.set(anio, (mes), dia);
                res = cal.getActualMaximum(Calendar.DATE);
                sFechaSol = (mes == 1 ? "0" + 2 : "0" + mes + 1) + "/" + res + "/" + (anio);
            }

        } else {
            System.out.println("linea opcional");
//            sFechaSol= sFechaSol;
        }
//        System.out.println("sFechaSol" + sFechaSol);

        return sFechaSol;
    }

    public String dateToStringFormatFechaAnioMesDiaDeceval(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
