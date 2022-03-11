DESCRIPTION = "Zsh configuration framework"
SECTION = "shells"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/LICENSE.txt;md5=cab5ca71c71cf4dff95c19d8e59df7ef"

PR = "r0"

SRC_URI = "git://github.com/ohmyzsh/ohmyzsh.git"

SRC_URI[md5sum] = "934bd36a4a3b1e7912fdff3ae764c7b6"
SRC_URI[sha256sum] = "09810190e0cf9ebf141ad780b994fce8198098fbeca418ec51df59eb51747182"

SRCREV = "c10241f3d1d7bf77d483e11869a6a00f1d2e5e88"

S = "${WORKDIR}/git"

do_install() {
    OMZ_DIR=${D}/usr/local/oh-my-zsh
    mkdir -p ${OMZ_DIR}
    cp -r ${B}/* ${OMZ_DIR}
    ZSHRC=${D}/etc/skel/.zshrc
    mkdir -p ${D}/etc/skel
    cp ${OMZ_DIR}/templates/zshrc.zsh-template ${ZSHRC}
    sed -i "1s/^/zstyle ':omz:update' mode disabled\n/" ${ZSHRC}
    sed -i '1s/^/ZSH_DISABLE_COMPFIX=true\n/' ${ZSHRC}
    sed -i 's#ZSH=.*$#ZSH="/usr/local/oh-my-zsh"#g' ${ZSHRC}
    sed -i 's/ZSH_THEME=".*"/ZSH_THEME="agnoster"/g' ${ZSHRC}
}

FILES_${PN} = "/usr/local/oh-my-zsh/* /etc/skel/.zshrc"
RDEPENDS_${PN} = "zsh"
