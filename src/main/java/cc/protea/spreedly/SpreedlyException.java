package cc.protea.spreedly;

public class SpreedlyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SpreedlyException(final Exception e) {
		super(e);
	}
}
