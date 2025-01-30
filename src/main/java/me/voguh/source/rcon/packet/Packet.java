package me.voguh.source.rcon.packet;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

public class Packet {

    private final int requestId;
    private final int type;
    private final byte[] payload;

    public int getRequestId() {
        return requestId;
    }

    public int getType() {
        return type;
    }

    public byte[] getPayload() {
        return payload;
    }

    public Packet(int requestId, int type, byte[] payload) {
        this.requestId = requestId;
        this.type = type;
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            Packet packet = (Packet) o;
            return requestId == packet.requestId && type == packet.type && Objects.deepEquals(payload, packet.payload);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, type, Arrays.hashCode(payload));
    }

    @Override
    public String toString() {
        return "Packet{" +
            "requestId=" + requestId +
            ", type=" + type +
            ", payload=" + new String(payload, StandardCharsets.US_ASCII) +
            "}";
    }

}
