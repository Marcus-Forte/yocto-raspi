FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://eth0.network \
"

do_install:append() {
    install -d ${D}${prefix}/lib/systemd/network/
    install -m 0644 ${WORKDIR}/eth0.network ${D}${prefix}/lib/systemd/network/
}

FILES:${PN} += " \
    ${noarch_base_libdir}/systemd/network \
"