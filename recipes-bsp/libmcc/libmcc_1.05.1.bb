# Copyright (C) 2013 Timesys Corporation
SUMMARY = "Multicore communication Library"
LICENSE = "GPL-2.0-only | BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c49712341497d0b5f2e40c30dff2af9d \
                    file://BSD_LICENSE;md5=10695b8f86532e5e44640acf4d92a2ef"

DEPENDS = "virtual/kernel-module-mcc"

SRC_URI = "http://repository.timesys.com/buildsources/l/libmcc/libmcc-${PV}/libmcc-${PV}.tar.bz2 \
           file://build-Fix-symlink-generation.patch \
           file://build-with-versioned-soname.patch \
           file://0001-Makefile-use-oe-ldflags.patch \
"

SRC_URI[sha256sum] = "5d6d85f2f17ba1016c24e3a1c1c934a9267021edaed67b63879112151f48562c"

S = "${WORKDIR}/libmcc-${PV}"

CFLAGS += "-I${STAGING_KERNEL_DIR}/include"

RDEPENDS:${PN} = "virtual/kernel-module-mcc"

COMPATIBLE_MACHINE = "(vf-generic-bsp)"

do_install() {
    oe_runmake 'DESTDIR=${D}' install
}

RDEPENDS:${PN}-dev += "virtual/kernel-module-mcc-dev"
PACKAGE_ARCH = "${MACHINE_ARCH}"
