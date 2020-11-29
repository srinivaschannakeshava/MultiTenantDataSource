package in.srini91.learn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import in.srini91.learn.db.config.DataSourceContext;

@Component
public class HeaderInterceptor implements AsyncHandlerInterceptor {
	@Value("${default-db}")
	private String defaultDb;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String dbHeader = request.getHeader("X-DB");
		if (dbHeader == null) {
			dbHeader = defaultDb;
		}
		DataSourceContext.setCurrentDb(dbHeader);

		return AsyncHandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		DataSourceContext.clear();
		AsyncHandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
