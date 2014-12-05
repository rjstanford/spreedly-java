package cc.protea.spreedly;

import cc.protea.util.http.Response;

class SpreedlyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public Response response = null;
	public String errorMessage;
	public String errorCode;

	public SpreedlyException(final Exception e) {
		super(e);
	}

	public SpreedlyException(final Exception e, final Response response) {
		super(e);
		this.response = response;
	}

	public SpreedlyException(final Exception e, final String errorCode, final String errorMessage) {
		super(e);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
