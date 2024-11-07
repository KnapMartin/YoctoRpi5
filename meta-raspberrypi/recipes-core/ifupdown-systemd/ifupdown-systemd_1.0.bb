SUMMARY = "Systemd service for ifupdown networking"
LICENSE = "CLOSED"
inherit systemd

# Explicitly include the service file in SRC_URI
SRC_URI = "file://ifupdown.service"

# Specify the systemd service file to install
SYSTEMD_SERVICE:${PN} = "ifupdown.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 644 ${WORKDIR}/ifupdown.service ${D}${systemd_unitdir}/system/
}

FILES:${PN} += "${systemd_unitdir}/system/ifupdown.service"
