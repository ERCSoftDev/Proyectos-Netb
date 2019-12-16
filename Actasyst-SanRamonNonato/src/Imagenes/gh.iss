; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "Actasyst"
#define MyAppVersion "7.0"
#define MyAppPublisher "ERC SoftDev7.0"
#define MyAppURL "enfryreyesciprian@gmail.com"
#define MyAppExeName "Acta.exe"

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{24B04545-ECF6-4DB8-98D4-BF21BF422FE6}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={pf}\Actasyst 7.0
DisableProgramGroupPage=yes
OutputDir=C:\Users\Computech\Desktop\actasss
OutputBaseFilename=ASsetup
SetupIconFile=C:\Users\Computech\Documents\NetBeansProjects\Actasyst-SanRamonNonato\src\Imagenes\A.ico
Password=admin102030
Compression=lzma
SolidCompression=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"
Name: "spanish"; MessagesFile: "compiler:Languages\Spanish.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "C:\Users\Computech\Desktop\actasss\Acta.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Computech\Documents\NetBeansProjects\Actasyst-SanRamonNonato\dist\lib\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{commonprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{commondesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}"; Flags: nowait postinstall skipifsilent
