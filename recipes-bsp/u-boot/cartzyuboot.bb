DESCRIPTION = "Install cartzy boot script."

DEPENDS += "u-boot-mkimage-native u-boot u-boot-script-boundary"

LICENSE = "CLOSED"

SRC_URI = "file://boot.scr"

inherit deploy

do_compile[noexec] = "1"

do_install () {
    install -Dm 0644 ${S}/boot.scr ${D}/boot.scr
}

do_deploy () {
    rm -rf ${DEPLOYDIR}/boot.scr-${MACHINE}
    rm -rf ${DEPLOYDIR}/boot.scr-nitrogen8mp
    rm -rf ${DEPLOYDIR}/boot.scr
    rm -rf ${DEPLOYDIR}/boot.scr-${MACHINE}-${PV}-${PR}

    install -Dm 0644 ${WORKDIR}/boot.scr ${DEPLOYDIR}/boot.scr-${MACHINE}-${PV}-${PR}
    ln -sf ${DEPLOYDIR}/boot.scr-${MACHINE}-${PV}-${PR} boot.scr
    ln -sf ${DEPLOYDIR}/boot.scr-${MACHINE}-${PV}-${PR} boot.scr-nitrogen8mp
    ln -sf ${DEPLOYDIR}/boot.scr-${MACHINE}-${PV}-${PR} boot.scr-${MACHINE}
}

addtask deploy after do_install before do_build

FILES:${PN} += "/"
