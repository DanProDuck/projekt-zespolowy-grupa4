package org.library.backend.util.database;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Locale;

public class CaseSensitiveNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {

    @Override
    protected Identifier getIdentifier(String name, final boolean quoted, final JdbcEnvironment jdbcEnvironment) {
        if (!isCaseInsensitive(jdbcEnvironment)) {
            name = name.toLowerCase(Locale.ROOT);
        }
        //initially quoted was passed as 2nd param
        return new Identifier(name, true);
    }


    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {

        if ( name == null ) {
            return null;
        }
        StringBuilder builder = new StringBuilder( name.getText().replace( '.', '_' ) );

        return getIdentifier( builder.toString(), name.isQuoted(), jdbcEnvironment );
    }

    private boolean isUnderscoreRequired(final char before, final char current, final char after) {
        return Character.isLowerCase( before ) && Character.isUpperCase( current ) && Character.isLowerCase( after );
    }
}
