require 'rubygems'
require 'xmlsimple'
require 'pp'

class SynchronizerConfig
  #check if should skip generating sync code for this me:
  #1.me's sync code should be writed manually, like policy file
  #2.me does't need synchronization, like perf
  @@skip_me=["config.KpiReporting", 
            "config.ExternalStorageDevices",
            "config.ExternalStorageSubnet",
            "system.System", 
            "config.Policy", 
            "config.PolicyFile", 
            "config.Rule", 
            "config.RuleAction", 
            "config.RuleCondition"]
  @@skip_package=["perf"]
  @@configFile="src/main/resources/META-INF/spring/fileEntityMap.xml"
  
  def initialize
    @entityInConfigFile = []
    
    doc = XmlSimple.xml_in(File.join(Project.projectPath, @@configFile), {'ForceArray'=>false})
    fileEntityBean = doc['bean'].select{|b| b['id'] == 'fileEntityMap'}[0]
    values = fileEntityBean['constructor-arg']['map']['entry'].map{|m| m['value']}
    #All MEs sync by file md5 compare
    values.each do |value|
      @entityInConfigFile = @entityInConfigFile | value.split(/[, ]/)
    end
    
    firstOnlyBean = doc['bean'].select{|b| b['id'] == 'firstOnlyEntityList'}[0]
    #All MEs for first only sync
    firstOnlyMes = firstOnlyBean['constructor-arg']['list']['value']
    @entityInConfigFile = @entityInConfigFile | firstOnlyMes
  end
  
  def skip?(me)
    return (@@skip_me.include?(me.full_name) or @@skip_package.include?(me.package))
  end
  
  def inConfigFile?(full_name)
    return @entityInConfigFile.include?(full_name)
  end
  
end