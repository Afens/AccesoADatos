package BddObjects;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;


public class NumeroTlfSQLData extends NumeroTlf implements SQLData {
    private String sqlTypeName;

    public NumeroTlfSQLData(){

    }
    public NumeroTlfSQLData(String prefijoPais, String numero){
        super(prefijoPais,numero);
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sqlTypeName;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        sqlTypeName = typeName;
        setPrefijoPais(stream.readString());
        setNumero(stream.readString());


    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(getPrefijoPais());
        stream.writeString(getNumero());
    }
}
