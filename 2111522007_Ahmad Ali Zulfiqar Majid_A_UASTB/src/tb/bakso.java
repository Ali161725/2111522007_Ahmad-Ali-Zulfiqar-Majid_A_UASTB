package tb;

import java.sql.SQLException;

//interface toko bakso
public interface bakso {
    public int noFaktur(int iharga) throws SQLException;

    public String admin(String iadm);

    public int harga(int iharga);

    public String tanggal(int iharga);

    public float bakso(int iharga);

    public float pangsit(int iharga);

    public float soto(int iharga);
}