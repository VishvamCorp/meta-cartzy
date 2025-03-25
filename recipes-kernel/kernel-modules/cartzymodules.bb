DESCRIPTION = "Install cartzy isp kernel modules."

LICENSE = "CLOSED"

inherit module

S = "${WORKDIR}/files"

do_compile[noexec] = "1"

SRC_URI = "file://vvcam-dwe.ko \
           file://vvcam-isp.ko \
           file://vvcam-video.ko \
           file://ov2775.ko \
           file://os08a20.ko \
           file://ar1335.ko \
           file://basler-camera-driver-vvcam.ko \
           file://imx219.ko \
           file://ov5695.ko \
           file://vcm-dw9790.ko \
           file://galcore.ko \
           file://custom_i2c_mod.ko \
           file://stmvl53l8cx.ko"

do_install() {
    mkdir -p ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/
    cp -r ${WORKDIR}/*.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/

    # Isp-vcam modules
   # cp ${S}/vvcam-dwe.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/
    #cp ${S}/vvcam-isp.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/
    #cp ${S}/vvcam-video.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/
    #cp ${S}/ov2775.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/
    #cp ${S}/os08a20.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/
    #cp ${S}/ar1335.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/
    #cp ${S}/basler-camera-driver-vvcam.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/
    #cp ${S}/imx219.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/
    #cp ${S}/ov5695.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/
    #cp ${S}/vcm-dw9790.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/

    # GPU Drivers.
    #cp ${S}/galcore.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/

    # Custom I2C.
    #cp ${S}/custom_i2c_mod.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/

    # TOFs.
    #cp ${S}/stmvl53l8cx.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/updates/

}

SSTATE_ALLOW_OVERLAP_FILES += "/"
