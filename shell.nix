let
  nixpkgsVer = "7069932e560daa85506f65ec7f63e4bbc5e0d22a";
  pkgsTar = fetchTarball "https://github.com/NixOS/nixpkgs/archive/${nixpkgsVer}.tar.gz";
  pkgs = import pkgsTar { config = {}; overlays = []; };
  libs = with pkgs; [
    libpulseaudio
    libGL
    glfw
    openal
    stdenv.cc.cc.lib
  ];
in pkgs.mkShell {
  name = "ram";

  buildInputs = with pkgs; [
    jdk21
    jq
  ] ++ [
#    (writeShellScriptBin "build" ''
#        jq -R -s 'split("\n") | map(select(startswith("#") or (length == 0) | not)) | map(split("\\s*=\\s*"; "")) | map({(.[0]): (.[1])}) | add' gradle.properties 1>gradle.json
#        ln -sf "${pkgs.substituteAll { src = ./template.build.gradle; } // builtins.fromJSON (builtins.readFile ./gradle.json)}" build.gradle
#        ./gradlew build
#    '')
  ] ++ libs;

  LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath libs;
}
