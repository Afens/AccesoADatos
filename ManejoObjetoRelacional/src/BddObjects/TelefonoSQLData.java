package BddObjects;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;


public class TelefonoSQLData extends Telefono implements SQLData {
    private String sqlTypeName;

    public TelefonoSQLData(String tipo){
        super(tipo);
        setNumeroTlf(new NumeroTlfSQLData());
    }
    @Override
    public String getSQLTypeName() throws SQLException {
        return sqlTypeName;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        sqlTypeName = typeName;
        setTipo(stream.readString());
        setNumeroTlf((NumeroTlf)stream.readObject());
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(getTipo());
        stream.writeObject((NumeroTlfSQLData)getNumeroTlf());
    }
}
