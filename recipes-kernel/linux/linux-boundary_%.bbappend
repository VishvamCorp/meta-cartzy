SUMMARY = "Linux kernel for Boundary Devices boards (Cartzy edition)"

SRC_URI = "git://github.com/VishvamCorp/linux.git;branch=${SRCBRANCH};protocol=https"
SRCBRANCH = "cartzy-if-6.6.y"
SRCREV = "e6a574ac50952550d0ede9d2614be1ae4942b508"

KBUILD_DEFCONFIG = "ezcart_defconfig"

KERNEL_VERSION_SANITY_SKIP="1"
