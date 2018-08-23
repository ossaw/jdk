/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javax.sql;

import java.sql.SQLException;
import java.io.PrintWriter;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * Interface that defines the methods which are common between
 * <code>DataSource</code>, <code>XADataSource</code> and
 * <code>ConnectionPoolDataSource</code>.
 *
 */
public interface CommonDataSource {

	/**
	 * <p>
	 * Retrieves the log writer for this <code>DataSource</code> object.
	 *
	 * <p>
	 * The log writer is a character output stream to which all logging and
	 * tracing messages for this data source will be printed. This includes
	 * messages printed by the methods of this object, messages printed by
	 * methods of other objects manufactured by this object, and so on. Messages
	 * printed to a data source specific log writer are not printed to the log
	 * writer associated with the <code>java.sql.DriverManager</code> class.
	 * When a <code>DataSource</code> object is created, the log writer is
	 * initially null; in other words, the default is for logging to be
	 * disabled.
	 *
	 * @return the log writer for this data source or null if logging is
	 *         disabled
	 * @exception java.sql.SQLException
	 *                if a database access error occurs
	 * @see #setLogWriter
	 * @since 1.4
	 */
	java.io.PrintWriter getLogWriter() throws SQLException;

	/**
	 * <p>
	 * Sets the log writer for this <code>DataSource</code> object to the given
	 * <code>java.io.PrintWriter</code> object.
	 *
	 * <p>
	 * The log writer is a character output stream to which all logging and
	 * tracing messages for this data source will be printed. This includes
	 * messages printed by the methods of this object, messages printed by
	 * methods of other objects manufactured by this object, and so on. Messages
	 * printed to a data source- specific log writer are not printed to the log
	 * writer associated with the <code>java.sql.DriverManager</code> class.
	 * When a <code>DataSource</code> object is created the log writer is
	 * initially null; in other words, the default is for logging to be
	 * disabled.
	 *
	 * @param out
	 *            the new log writer; to disable logging, set to null
	 * @exception SQLException
	 *                if a database access error occurs
	 * @see #getLogWriter
	 * @since 1.4
	 */
	void setLogWriter(java.io.PrintWriter out) throws SQLException;

	/**
	 * <p>
	 * Sets the maximum time in seconds that this data source will wait while
	 * attempting to connect to a database. A value of zero specifies that the
	 * timeout is the default system timeout if there is one; otherwise, it
	 * specifies that there is no timeout. When a <code>DataSource</code> object
	 * is created, the login timeout is initially zero.
	 *
	 * @param seconds
	 *            the data source login time limit
	 * @exception SQLException
	 *                if a database access error occurs.
	 * @see #getLoginTimeout
	 * @since 1.4
	 */
	void setLoginTimeout(int seconds) throws SQLException;

	/**
	 * Gets the maximum time in seconds that this data source can wait while
	 * attempting to connect to a database. A value of zero means that the
	 * timeout is the default system timeout if there is one; otherwise, it
	 * means that there is no timeout. When a <code>DataSource</code> object is
	 * created, the login timeout is initially zero.
	 *
	 * @return the data source login time limit
	 * @exception SQLException
	 *                if a database access error occurs.
	 * @see #setLoginTimeout
	 * @since 1.4
	 */
	int getLoginTimeout() throws SQLException;

	// ------------------------- JDBC 4.1 -----------------------------------

	/**
	 * Return the parent Logger of all the Loggers used by this data source.
	 * This should be the Logger farthest from the root Logger that is still an
	 * ancestor of all of the Loggers used by this data source. Configuring this
	 * Logger will affect all of the log messages generated by the data source.
	 * In the worst case, this may be the root Logger.
	 *
	 * @return the parent Logger for this data source
	 * @throws SQLFeatureNotSupportedException
	 *             if the data source does not use {@code java.util.logging}
	 * @since 1.7
	 */
	public Logger getParentLogger() throws SQLFeatureNotSupportedException;
}
