package net.coderbot.iris.vertices;

import java.nio.ByteBuffer;

public class QuadViewVanilla extends QuadView {
	private int stride;
	private int writeOffset;
	private ByteBuffer buffer;

	public void setup(ByteBuffer buffer, int writeOffset, int stride) {
		this.stride = stride;
		this.writeOffset = writeOffset;
		this.buffer = buffer;
	}

	@Override
	public float x(int index) {
		return buffer.getFloat(writeOffset - stride * (4 - index));
	}

	@Override
	public float y(int index) {
		return buffer.getFloat(writeOffset + 4 - stride * (4 - index));
	}

	@Override
	public float z(int index) {
		return buffer.getFloat(writeOffset + 8 - stride * (4 - index));
	}

	@Override
	public float u(int index) {
		return buffer.getFloat(writeOffset + 16 - stride * (4 - index));
	}

	@Override
	public float v(int index) {
		return buffer.getFloat(writeOffset + 20 - stride * (4 - index));
	}
}
