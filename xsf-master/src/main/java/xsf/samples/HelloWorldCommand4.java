package xsf.samples;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.xtivia.xsf.core.annotation.Route;
import com.xtivia.xsf.core.commands.CommandResult;
import com.xtivia.xsf.core.commands.ICommand;
import com.xtivia.xsf.core.commands.IContext;


@Route(uri="/getuserxml/{userId}", method="GET", authenticated=false)
public class HelloWorldCommand4 implements ICommand{

	@Override
	public CommandResult execute(IContext context) throws Exception {
		// TODO Auto-generated method stub
		String userIdStr = context.find("userId");
		long userId = Long.parseLong(userIdStr);
		User user = UserLocalServiceUtil.getUser(userId);
		String userXml = user.toXmlString();
		return new CommandResult().setSucceeded(true).setData(userXml).setMessage("");
	}

}
