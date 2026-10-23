import java.sql.*;

public class Usuario {
    
    static String todos = "SELECT * FROM usuarios ORDER BY idusuarios";
    static String ids = "SELECT idusuarios FROM usuarios ORDER BY idusuarios";
    
    int idusuarios;
    String nombre, nom_usr, nip, rol, estado;
    
    public Usuario() {
        
    }

    public Usuario(int idusuarios, String nombre, String nom_usr, String nip, String rol, String estado) {
        this.idusuarios = idusuarios;
        this.nombre = nombre;
        this.nom_usr = nom_usr;
        this.nip = nip;
        this.rol = rol;
        this.estado = estado;
    }
    
    public int insertar(Connection con){
        int resultado = 0;
        try {
            String sql = "INSERT INTO usuarios VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idusuarios);
            ps.setString(2, nombre);
            ps.setString(3, nom_usr);
            ps.setString(4, nip);
            ps.setString(5, rol);
            ps.setString(6, estado);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            return resultado;
        }
    }
    
    public int borrar(Connection con){
        int resultado = 0;
        try {
            String sql = "DELETE FROM usuarios WHERE idusuarios = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idusuarios);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con){
        int resultado = 0;
        try {
            String sql = "UPDATE usuarios SET nombre = ?, nom_usr = ?, nip = ?, rol = ?, estado = ? WHERE idusuarios = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, nom_usr);
            ps.setString(3, nip);
            ps.setString(4, rol);
            ps.setString(5, estado);
            ps.setInt(6, idusuarios);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            return resultado;
        }
    }
    
}