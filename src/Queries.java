public class Queries {
    static String todo = "SELECT * FROM mediciones";
    static String clave_estaciones = "SELECT clave FROM estaciones";
    static String por_estacion = "SELECT * FROM mediciones WHERE estaciones_clave = '%s' ORDER BY instante DESC";
    static String por_periodo = "SELECT * FROM mediciones WHERE "
            + "DATE (instante) BETWEEN '%s' AND '%s'";
    static String promedio = "SELECT estaciones_clave AS estacion, "
            + "MONTH(instante) as mes, ROUND(AVG(temperatura),2) AS temperatura_prom FROM mediciones"
            + " WHERE estaciones_clave = '%s' GROUP by MONTH(instante);"; 
    static String max_min_semana = "SELECT estaciones_clave AS estacion, "
            + "WEEK(instante) AS semana, "
            + "ROUND(MIN(precipitacion),2) AS precipitacion_min, "
            + "ROUND(MAX(precipitacion),2) AS precipitacion_max FROM mediciones "
            + "WHERE estaciones_clave = '%s' GROUP by WEEK(instante);";
    static String hoy = "SELECT * FROM mediciones WHERE DATE(instante) = CURRENT_DATE AND estaciones_clave = '%s'";

}   
