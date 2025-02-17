DESCRIPTION = "Userspace DMA I/O library"
LICENSE = "BSD"
PV = "1.2.0"
PR = "r0"

DEPENDS = "boost"
RDEPENDS_${PN} = "boost-log boost-program-options"

inherit pkgconfig cmake

SRCREV = "dfd24a10cb6bb0fde9f576cdfe7d5677fb492480"
SRC_URI = "git://github.com/MicroTCA-Tech-Lab/libudmaio.git;protocol=https"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e218aa5496fc02972b9c9425e527094c"

EXTRA_OECMAKE += "-DCMAKE_SKIP_RPATH=TRUE"

S="${WORKDIR}/git"

RDEPENDS_${PN} = "uio-users-group uio-users-udev-rule"
