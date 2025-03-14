/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.id.platform;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Map;

public class Platform extends Id<Platform> {

    private final Map<InterfaceAddress, NetworkInterface> activeExternalAddresses;

    private final Map<InterfaceAddress, NetworkInterface> activeLoopbackAddresses;

    public Platform(Map<InterfaceAddress, NetworkInterface> activeExternalAddresses, Map<InterfaceAddress, NetworkInterface> activeLoopbackAddresses) {
        this.activeExternalAddresses = activeExternalAddresses;
        this.activeLoopbackAddresses = activeLoopbackAddresses;
    }

    public Map<InterfaceAddress, NetworkInterface> getActiveLoopbackAddresses() {
        return activeLoopbackAddresses;
    }

    public Map<InterfaceAddress, NetworkInterface> getActiveExternalAddresses() {
        return activeExternalAddresses;
    }
}
