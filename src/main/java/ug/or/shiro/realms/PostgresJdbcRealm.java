package ug.or.shiro.realms;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.realm.jdbc.JdbcRealm;

import ug.or.nda.ejb.UserEJBI;
import ug.or.nda.entities.User;

public class PostgresJdbcRealm {//extends JdbcRealm {
	
	@EJB
	private UserEJBI userEJB;

	private Logger log = Logger.getLogger(getClass());

	/**
	 * The default query used to retrieve account data for the user.
	 */
	protected static final String DEFAULT_AUTHENTICATION_QUERY = "SELECT pass FROM user WHERE username = ?";

	/**
	 * The default query used to retrieve the roles that apply to a user.
	 */
	protected static final String DEFAULT_USER_ROLES_QUERY =
			// from user self
			"select rl.name from user_role r left join user u on u.id = r.user_id left join role rl on rl.id=r.role_id where u.username = ? ";

	protected String authenticationQuery = DEFAULT_AUTHENTICATION_QUERY;

	protected String userRolesQuery = DEFAULT_USER_ROLES_QUERY;

	protected boolean permissionsLookupEnabled = false;
	
	//private static final Logger log = LoggerFactory.getLogger(PostgresJdbcRealm.class);

	/**
	 * jndiDataSourceName
	 */
	protected String jndiDataSourceName;

	public PostgresJdbcRealm() {
		super();
	}

	public String getJndiDataSourceName() {
		return jndiDataSourceName;
	}

	/*public void setJndiDataSourceName(String jndiDataSourceName) {
		this.jndiDataSourceName = jndiDataSourceName;
		this.dataSource = getDataSourceFromJNDI(jndiDataSourceName);
	}*/

	private DataSource getDataSourceFromJNDI(String jndiDataSourceName) {
		try {
			InitialContext ic = new InitialContext();
			return (DataSource) ic.lookup(jndiDataSourceName);
		} catch (NamingException e) {
			log.error("JNDIr while retrieving " + jndiDataSourceName, e);
			throw new AuthorizationException(e);
		}
	}

	
/*
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();

		if (username == null) {
			throw new AccountException("Null usernames are not allowed by this realm.");
		}
		AuthenticationInfo info = super.doGetAuthenticationInfo(token);
		String password = null;
		try {
			log.info(" userEJB----> " + userEJB);
			User user = userEJB.findUserByUsername(username);
			log.info(" user ----> " + user);
			password = user.getPwdhash();
			if (user == null || password == null) {
				throw new UnknownAccountException("No account found for user [" + username + "]");
			}
			info = new SimpleAuthenticationInfo(username, password.toCharArray(), getName());

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return info;

	}*/
}
