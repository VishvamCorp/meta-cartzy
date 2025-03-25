SUMMARY = "CARTZY image with ML stuff."

LICENSE = "CLOSED"

inherit core-image

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-profile \
    tools-sdk \
    package-management \
    splash \
    nfs-client \
    tools-debug \
    ssh-server-openssh \
    tools-testapps \
    hwcodecs \
"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-imx-isp \
    packagegroup-imx-security \
    firmwared \
"

IMAGE_INSTALL += " \
    curl \
    packagegroup-imx-ml \
    ${IMAGE_INSTALL_OPENCV}"

IMAGE_INSTALL_OPENCV              = ""
IMAGE_INSTALL_OPENCV:imxgpu       = "${IMAGE_INSTALL_OPENCV_PKGS}"
IMAGE_INSTALL_OPENCV:mx93-nxp-bsp = "${IMAGE_INSTALL_OPENCV_PKGS}"
IMAGE_INSTALL_OPENCV_PKGS = " \
    opencv-apps \
    opencv-samples \
    python3-opencv"

IMAGE_INSTALL_WIFI_BT ?= "${IMAGE_INSTALL_WIFI_BT_PKGS}"
IMAGE_INSTALL_WIFI_BT_PKGS = " \
    bdsdmac-firmware \
    if573-sdio-firmware \
    lwb5plus-sdio-sa-firmware \
    nx61x-firmware \
    kernel-module-bdsdmac-backports \
"

CORE_IMAGE_EXTRA_INSTALL += " \
	can-utils \
	e2fsprogs \
	evtest \
	fw-env-rules \
	i2c-tools \
	iperf3 \
	iproute2 \
	libdrm-tests \
	memtester \
	minicom \
	mmc-utils \
	modemmanager \
	networkmanager \
	networkmanager-nmcli \
	openssh \
	packagegroup-fsl-isp \
	packagegroup-fsl-opencv-imx \
	packagegroup-imx-ml \
	packagegroup-tools-bluetooth \
	pciutils \
	psplash \
	screen \
	spitools \
	strace \
	tslib-tests tslib-calibrate \
	u-boot-boundary-env \
	u-boot-fw-utils \
	udev-rules-imx \
	v4l-utils \
	wireless-regdb-static \
	git \
	zip \
	${IMAGE_INSTALL_WIFI_BT} \
"

IMAGE_INSTALL += " cartzyuboot cartzymodules"

PROVIDES += "cartzyimageml"

inherit extrausers
EXTRA_USERS_PARAMS = " useradd cartzy; \
                       usermod -p 'cartzy' cartzy; \
                       usermod  -a -G sudo cartzy;"

# For compatibility.
IMAGE_INSTALL:remove = "kernel-module-isp-vvcam"
RDEPENDS:${PN}:remove = "kernel-module-isp-vvcam"
PACKAGEGROUP_CORE_BASE:remove = "kernel-module-isp-vvcam"
SKIP_RECIPE[kernel-module-isp-vvcam] = "Manually excluded due to conflicts"
